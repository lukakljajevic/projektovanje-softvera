/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.AkademskiUspeh;
import domen.Korisnik;
import domen.Nastavnik;
import domen.Predaje;
import domen.Predmet;
import domen.PredmetStudijskiProgram;
import domen.Referenca;
import domen.ReferencaNastavnik;
import domen.ReferencaSpoljniAutor;
import domen.SpoljniAutor;
import domen.StudijskiProgram;
import domen.TipNastavnika;
import domen.TipUspeha;
import domen.Usavrsavanje;
import forme.GlavnaServerskaForma;
import java.io.IOException;
import java.net.Socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.KomunikacijaServer;
import operacije.Operacije;
import so.OpstaSO;
import so.korisnik.UlogujKorisnika;
import so.nastavnik.IzmeniNastavnika;

import so.nastavnik.ObrisiNastavnika;

import so.nastavnik.PretraziNastavnike;

import so.nastavnik.UnesiNastavnika;




import so.nastavnik.VratiPodatkeONastavniku;
import so.nastavnik.VratiSveNastavnike;
import so.predmet.IzmeniPredmet;

import so.predmet.ObrisiPredmet;

import so.predmet.PretraziPredmete;

import so.predmet.UnesiPredmet;

import so.predmet.VratiPodatkeOPredmetu;
import so.predmet.VratiSvePredmete;

import so.referenca.PretraziReference;
import so.referenca.UnesiReferencu;
import so.spoljniAutor.PretraziAutore;
import so.studijskiProgram.VratiSveStudijskePrograme;
import so.tipNastavnika.VratiSveTipoveNastavnika;
import so.tipUspeha.VratiSveTipoveUspeha;
import transfer.ServerOdgovor;

/**
 *
 * @author Luka
 */
public class KontrolerServer {

    private static KontrolerServer instance;
    private GlavnaServerskaForma gsf;
    private DBBroker db;
    private List<Korisnik> listaUlogovanihKorisnika;
    HashMap<Korisnik, Socket> ulogovaniKorisnici;

    private KontrolerServer() {
        db = new DBBroker();
        listaUlogovanihKorisnika = new ArrayList<>();
        ulogovaniKorisnici = new HashMap<>();
    }

    public static KontrolerServer getInstance() {
        if (instance == null) {
            instance = new KontrolerServer();
        }
        return instance;
    }

    public boolean ulogujKorisnika(String username, String password, Socket soket) {
        boolean uspesno = false;
        Korisnik k = new Korisnik();
        k.setUsername(username);
        k.setPassword(password);
        try {
            OpstaSO ulogujKorisnika = new UlogujKorisnika(k, db);
            ulogujKorisnika.izvrsenjeSO();
            Korisnik ulogovaniKorisnik = (Korisnik) ulogujKorisnika.getObject();
            System.out.println(ulogovaniKorisnik);
            if (ulogovaniKorisnik.getKorisnikID() != 0) {
                // Dodaj u listu
                listaUlogovanihKorisnika.add(ulogovaniKorisnik);
                // Dodaj u hashmapu
                ulogovaniKorisnici.put(ulogovaniKorisnik, soket);
                uspesno = true;
                gsf.osveziTabelu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uspesno;
    }

    public void ukljuciServer() {
        KomunikacijaServer.getInstance().setServerRadi(true);
        KomunikacijaServer.getInstance().setServerJeIskljucen(false);
    }

    public HashMap<Korisnik, Socket> getUlogovaniKorisnici() {
        return ulogovaniKorisnici;
    }

    public void setUlogovaniKorisnici(HashMap<Korisnik, Socket> ulogovaniKorisnici) {
        this.ulogovaniKorisnici = ulogovaniKorisnici;
    }

    public List<Korisnik> getListaUlogovanihKorisnika() {
        return listaUlogovanihKorisnika;
    }

    public void setListaUlogovanihKorisnika(List<Korisnik> listaUlogovanihKorisnika) {
        this.listaUlogovanihKorisnika = listaUlogovanihKorisnika;
    }

    public GlavnaServerskaForma getGsf() {
        return gsf;
    }

    public void setGsf(GlavnaServerskaForma gsf) {
        this.gsf = gsf;
    }

    public boolean izbaciIzabranogKorisnika(int row) {
        boolean vrati = false;
        Korisnik izabraniKorisnik = listaUlogovanihKorisnika.get(row);
        for (Map.Entry<Korisnik, Socket> entry : ulogovaniKorisnici.entrySet()) {
            Korisnik key = entry.getKey();
            Socket value = entry.getValue();
            if (izabraniKorisnik.equals(key)) {

                ServerOdgovor so = new ServerOdgovor();
                so.setOperacija(Operacije.LOGOUT);
                KomunikacijaServer.getInstance().posaljiOdgovorKljientu(value, so);

                try {
                    value.close();
                } catch (IOException ex) {
                    Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
                }

                ulogovaniKorisnici.remove(key);
                listaUlogovanihKorisnika.remove(row);

                vrati = true;
                return vrati;

            }

        }

        return vrati;
    }

    public void uspesnoZaustavljenServer() {
        gsf.uspesnoZaustavljenServer();
    }

    public void uspesnoPokretanjeServera() {
        gsf.uspesnoPokrenutServer();
    }

    public boolean izbaciSveKorisnike() {
        boolean vrati = false;

        for (Map.Entry<Korisnik, Socket> entry : ulogovaniKorisnici.entrySet()) {
            Korisnik key = entry.getKey();
            Socket value = entry.getValue();

            ServerOdgovor so = new ServerOdgovor();
            so.setOperacija(Operacije.LOGOUT);
            KomunikacijaServer.getInstance().posaljiOdgovorKljientu(value, so);

            try {
                value.close();
            } catch (IOException ex) {
                Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            listaUlogovanihKorisnika.remove(key);

        }
        vrati = true;
        ulogovaniKorisnici = new HashMap<>();
        return vrati;
    }

    public List<Nastavnik> vratiSveNastavnike() {
        OpstaSO vratiSveNastavnike = new VratiSveNastavnike(new Nastavnik(), db);
        List<Nastavnik> listaNastavnika = new ArrayList<>();
        try {
            vratiSveNastavnike.izvrsenjeSO();
            listaNastavnika = (List<Nastavnik>) vratiSveNastavnike.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaNastavnika;
    }

    public List<Nastavnik> pretraziNastavnike(Nastavnik nastavnik) {
        OpstaSO pretraziNastavnike = new PretraziNastavnike(nastavnik, db);
        List<Nastavnik> listaNastavnika = new ArrayList<>();
        try {
            pretraziNastavnike.izvrsenjeSO();
            listaNastavnika = (List<Nastavnik>) pretraziNastavnike.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaNastavnika;
    }

    public List<Predmet> pretraziPredmete(Predmet predmet) {
        OpstaSO pretraziPredmete = new PretraziPredmete(predmet, db);
        List<Predmet> listaPredmeta = new ArrayList<>();
        try {
            pretraziPredmete.izvrsenjeSO();
            listaPredmeta = (List<Predmet>) pretraziPredmete.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPredmeta;
    }

    public Predmet vratiPodatkeOPredmetu(Predmet predmet) {
        OpstaSO vratiPodatkeOPredmetu = new VratiPodatkeOPredmetu(predmet, db);
        Predmet p = new Predmet();
        try {
            vratiPodatkeOPredmetu.izvrsenjeSO();
            p = (Predmet) vratiPodatkeOPredmetu.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public Nastavnik vratiPodatkeONastavniku(Nastavnik nastavnik) {
        Nastavnik n = new Nastavnik();
        OpstaSO vratiPodatkeONastavniku = new VratiPodatkeONastavniku(nastavnik, db);

        try {
            vratiPodatkeONastavniku.izvrsenjeSO();
            n = (Nastavnik) vratiPodatkeONastavniku.getObject();

            

        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    

    public List<TipNastavnika> vratiSveTipoveNastavnika() {
        List<TipNastavnika> listaSvihTipovaNastavnika = new ArrayList<>();
        OpstaSO vratiSveTipoveNastavnika = new VratiSveTipoveNastavnika(new TipNastavnika(), db);
        try {
            vratiSveTipoveNastavnika.izvrsenjeSO();
            listaSvihTipovaNastavnika = (List<TipNastavnika>) vratiSveTipoveNastavnika.getObject();
        } catch (Exception ex1) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex1);
        }
        return listaSvihTipovaNastavnika;
    }

    public List<TipUspeha> vratiSveTipoveUspeha() {
        List<TipUspeha> listaSvihTipovaUspeha = new ArrayList<>();
        OpstaSO vratiSveTipoveUspeha = new VratiSveTipoveUspeha(null, db);

        try {
            vratiSveTipoveUspeha.izvrsenjeSO();
            listaSvihTipovaUspeha = (List<TipUspeha>) vratiSveTipoveUspeha.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaSvihTipovaUspeha;
    }
    
    // DODATNO
    public List<Referenca> pretraziReference(Referenca referenca) {
        List<Referenca> listaPronadjenihReferenci = new ArrayList<>();
        OpstaSO pretraziReference = new PretraziReference(referenca, db);
        try {
            pretraziReference.izvrsenjeSO();
            listaPronadjenihReferenci = (List<Referenca>) pretraziReference.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPronadjenihReferenci;
    }

    public boolean unesiNastavnika(Nastavnik nastavnik) {
        boolean uspesnoUnet = false;
        OpstaSO unesiNastavnika = new UnesiNastavnika(nastavnik, db);
        try {
            unesiNastavnika.izvrsenjeSO();
            uspesnoUnet = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesnoUnet;
    }

    public List<StudijskiProgram> vratiSveStudijskePrograme() {
        List<StudijskiProgram> listaSvihStudijskihPrograma = new ArrayList<>();
        OpstaSO vratiSveStudijskePrograme = new VratiSveStudijskePrograme(new StudijskiProgram(), db);
        try {
            vratiSveStudijskePrograme.izvrsenjeSO();
            listaSvihStudijskihPrograma = (List<StudijskiProgram>) vratiSveStudijskePrograme.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSvihStudijskihPrograma;
    }

    public boolean unesiPredmet(Predmet predmet) {
        boolean uspesnoUnet = false;
        OpstaSO unesiPredmet = new UnesiPredmet(predmet, db);
        try {
            unesiPredmet.izvrsenjeSO();
            uspesnoUnet = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesnoUnet;
    }

    // DODATNO
    public List<SpoljniAutor> pretraziAutore(SpoljniAutor autor) {
        List<SpoljniAutor> listaPronadjenihAutora = new ArrayList<>();
        OpstaSO pretraziAutore = new PretraziAutore(autor, db);

        try {
            pretraziAutore.izvrsenjeSO();
            listaPronadjenihAutora = (List<SpoljniAutor>) pretraziAutore.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPronadjenihAutora;

    }

    public boolean unesiReferencu(Referenca referenca) {
        boolean vrati = false;
        OpstaSO unesiReferencu = new UnesiReferencu(referenca, db);
        try {
            unesiReferencu.izvrsenjeSO();
            vrati = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean obrisiPredmet(Predmet predmet) {
        boolean obrisan = false;
        try {
            OpstaSO obrisiPredmet = new ObrisiPredmet(predmet, db);
            obrisiPredmet.izvrsenjeSO();
            obrisan = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obrisan;
    }

    public boolean obrisiNastavnika(Nastavnik nastavnik) {
        boolean obrisan = false;
        
        try {
            OpstaSO obrisiNastavnika = new ObrisiNastavnika(nastavnik, db);
            obrisiNastavnika.izvrsenjeSO();
            obrisan = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return obrisan;
    }

    public List<Predmet> vratiSvePredmete() {
        List<Predmet> listaSvihPredmeta = new ArrayList<>();
        OpstaSO vratiSvePredmete = new VratiSvePredmete(new Predmet(), db);
        
        try {
            vratiSvePredmete.izvrsenjeSO();
            listaSvihPredmeta = (List<Predmet>) vratiSvePredmete.getObject();
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSvihPredmeta;
    }

    public boolean izmeniPredmet(Predmet predmet, List<StudijskiProgram> listaDodajStudijskiProgram, List<StudijskiProgram> listaObrisiStudijskiProgram, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        OpstaSO izmeniPredmet = new IzmeniPredmet(predmet, db, listaDodajStudijskiProgram, listaObrisiStudijskiProgram, listaDodajPredaje, listaObrisiPredaje, listaIzmeniPredaje);
        boolean uspesno = false;
        try {
            izmeniPredmet.izvrsenjeSO();
            uspesno = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uspesno;
    }

    public boolean izmeniNastavnika(Nastavnik nastavnik, List<AkademskiUspeh> listaDodajAkademskiUspeh, List<AkademskiUspeh> listaObrisiAkademskiUspeh, List<Usavrsavanje> listaDodajUsavrsavanje, List<Usavrsavanje> listaObrisiUsavrsavanje, List<Referenca> listaDodajReferencu, List<Referenca> listaObrisiReferencu, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        boolean uspesno = false;
        
        OpstaSO izmeniNastavnika = new IzmeniNastavnika(nastavnik, db, listaDodajAkademskiUspeh, listaObrisiAkademskiUspeh, listaDodajUsavrsavanje, listaObrisiUsavrsavanje, listaDodajReferencu, listaObrisiReferencu, listaDodajPredaje, listaObrisiPredaje, listaIzmeniPredaje);
        
        try {
            izmeniNastavnika.izvrsenjeSO();
            uspesno = true;
        } catch (Exception ex) {
            Logger.getLogger(KontrolerServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return uspesno;
        
    }

}
