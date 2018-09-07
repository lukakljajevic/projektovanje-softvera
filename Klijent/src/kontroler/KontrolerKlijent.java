/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AkademskiUspeh;
import domen.Nastavnik;
import domen.Predaje;
import domen.Predmet;
import domen.Referenca;
import domen.SpoljniAutor;
import domen.StudijskiProgram;
import domen.TipNastavnika;
import domen.TipUspeha;
import domen.Usavrsavanje;
import forme.GlavnaKlijentskaForma;
import forme.GlavnaNastavnikForma;
import forme.GlavnaPredmetForma;
import forme.IzmenaNastavnikaForma;
import forme.IzmenaPredmetaForma;
import forme.LoginForma;
import forme.UnosNoveReferenceForma;
import forme.UnosNovogNastavnikaForma;
import forme.UnosNovogPredmetaForma;
import java.util.ArrayList;
import java.util.List;

import komunikacija.KomunikacijaKlijent;
import niti.ObradaOdgovoraServeraNit;
import operacije.Operacije;
import transfer.KlijentZahtev;

/**
 *
 * @author Luka
 */
public class KontrolerKlijent {

    private static KontrolerKlijent instance;
    private LoginForma loginForma;
    private GlavnaKlijentskaForma gkf;
    ObradaOdgovoraServeraNit oos;
    private List<Nastavnik> listaNastavnikaPretraga;
    private String trenutnaForma;
    private List<Predmet> listaPredmetaPretraga;
    private GlavnaPredmetForma glavnaPredmetForma;
    private GlavnaNastavnikForma glavnaNastavnikForma;
    private UnosNovogNastavnikaForma unosNastavnikaForma;
    private List<TipNastavnika> listaTipovaNastavnika;
    private List<TipUspeha> listaTipovaUspeha;
    private UnosNovogPredmetaForma unosPredmetaForma;
    private UnosNoveReferenceForma unosReferenceForma;
    private IzmenaPredmetaForma izmenaPredmetaForma;
    private List<StudijskiProgram> listaStudijskiPrograma;
    private Predmet predmetZaIzmenu;
    private IzmenaNastavnikaForma izmenaNastavnikaForma;
    private Nastavnik nastavnikZaIzmenu;

    public Nastavnik getNastavnikZaIzmenu() {
        return nastavnikZaIzmenu;
    }

    public void setNastavnikZaIzmenu(Nastavnik nastavnikZaIzmenu) {
        this.nastavnikZaIzmenu = nastavnikZaIzmenu;
    }

    public IzmenaNastavnikaForma getIzmenaNastavnikaForma() {
        return izmenaNastavnikaForma;
    }

    public void setIzmenaNastavnikaForma(IzmenaNastavnikaForma izmenaNastavnikaForma) {
        this.izmenaNastavnikaForma = izmenaNastavnikaForma;
    }

    public Predmet getPredmetZaIzmenu() {
        return predmetZaIzmenu;
    }

    public void setPredmetZaIzmenu(Predmet predmetZaIzmenu) {
        this.predmetZaIzmenu = predmetZaIzmenu;
    }

    public List<StudijskiProgram> getListaStudijskiPrograma() {
        return listaStudijskiPrograma;
    }

    public void setListaStudijskiPrograma(List<StudijskiProgram> listaStudijskiPrograma) {
        this.listaStudijskiPrograma = listaStudijskiPrograma;
    }

    public IzmenaPredmetaForma getIzmenaPredmetaForma() {
        return izmenaPredmetaForma;
    }

    public void setIzmenaPredmetaForma(IzmenaPredmetaForma izmenaPredmetaForma) {
        this.izmenaPredmetaForma = izmenaPredmetaForma;
    }

    public UnosNoveReferenceForma getUnosReferenceForma() {
        return unosReferenceForma;
    }

    public void setUnosReferenceForma(UnosNoveReferenceForma unosReferenceForma) {
        this.unosReferenceForma = unosReferenceForma;
    }

    public UnosNovogPredmetaForma getUnosPredmetaForma() {
        return unosPredmetaForma;
    }

    public void setUnosPredmetaForma(UnosNovogPredmetaForma unosPredmetaForma) {
        this.unosPredmetaForma = unosPredmetaForma;
    }

    public List<TipUspeha> getListaTipovaUspeha() {
        return listaTipovaUspeha;
    }

    public void setListaTipovaUspeha(List<TipUspeha> listaTipovaUspeha) {
        this.listaTipovaUspeha = listaTipovaUspeha;
    }

    public GlavnaNastavnikForma getGlavnaNastavnikForma() {
        return glavnaNastavnikForma;
    }

    public void setGlavnaNastavnikForma(GlavnaNastavnikForma glavnaNastavnikForma) {
        this.glavnaNastavnikForma = glavnaNastavnikForma;
    }

    private KontrolerKlijent() {
        listaNastavnikaPretraga = new ArrayList<>();
        listaPredmetaPretraga = new ArrayList<>();
        trenutnaForma = "";
    }

    public static KontrolerKlijent getInstance() {
        if (instance == null) {
            instance = new KontrolerKlijent();
        }
        return instance;
    }

    public LoginForma getLoginForma() {
        return loginForma;
    }

    public void setLoginForma(LoginForma loginForma) {
        this.loginForma = loginForma;
    }

    public List<Nastavnik> getListaNastavnikaPretraga() {
        return listaNastavnikaPretraga;
    }

    public void setListaNastavnikaPretraga(List<Nastavnik> listaNastavnikaPretraga) {
        this.listaNastavnikaPretraga = listaNastavnikaPretraga;
    }

    public void uspesnoUlogovan(boolean ulogovan) {
        loginForma.uspesnoUlogovan(ulogovan);
    }

    public void login(String username, String password) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.LOGIN);
        kz.setUsername(username);
        kz.setPassword(password);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void logoutLoginForma() {
        oos.interrupt();
        loginForma.ugasiAplikaciju();

    }

    public void logoutGlavnaForma() {
        oos.interrupt();
        gkf.ugasiAplikaciju();
    }

    public void pokreniObraduOdgovora() {
        oos = new ObradaOdgovoraServeraNit();
        oos.start();
    }

    public void ugasiAplikaciju() {
        System.exit(0);
    }

    public void serverNijePokrenut() {
        loginForma.serverNijePokrenut();
    }

    public GlavnaKlijentskaForma getGkf() {
        return gkf;
    }

    public void setGkf(GlavnaKlijentskaForma gkf) {
        this.gkf = gkf;
    }

    public String getTrenutnaForma() {
        return trenutnaForma;
    }

    public void setTrenutnaForma(String trenutnaForma) {
        this.trenutnaForma = trenutnaForma;
    }

    public void vratiSveNastavnike() {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_NASTAVNIKE);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziSveNastavnike(List<Nastavnik> listaNastavnika, String forma) {
        switch (forma) {
            case "unosPredmetaForma":
                unosPredmetaForma.setListaNastavnikaPretraga(listaNastavnika);
                unosPredmetaForma.osveziTabele();
                break;
            case "unosReferenceForma":
                unosReferenceForma.setListaNastavnikaPretraga(listaNastavnika);
                unosReferenceForma.osveziTabele();
                break;
            case "izmenaPredmetaForma":
                izmenaPredmetaForma.setListaNastavnikaPretraga(listaNastavnika);
                izmenaPredmetaForma.osveziTabele();
                break;
            default:
                setListaNastavnikaPretraga(listaNastavnika);
                gkf.osveziTabeluNastavnika();
                break;
        }

    }

    public void prikaziListu(List<Nastavnik> lista) {
        System.out.println("Lista nastavnika:");
        for (Nastavnik nastavnik : lista) {
            System.out.println(nastavnik);
        }
    }

    public void pretraziNastavnike(String imePrezime) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.PRETRAZI_NASTAVNIKE);
        Nastavnik n = new Nastavnik();
        n.setImePrezime(imePrezime);
        kz.setNastavnik(n);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public List<Predmet> getListaPredmetaPretraga() {
        return listaPredmetaPretraga;
    }

    public void setListaPredmetaPretraga(List<Predmet> listaPredmetaPretraga) {
        this.listaPredmetaPretraga = listaPredmetaPretraga;
    }

    public void vratiSvePredmete() {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_PREDMETE);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziPredmete(List<Predmet> listaSvihPredmeta, String forma) {

//        ispisiListuPredmeta(listaSvihPredmeta);
        switch (trenutnaForma) {
            case "unosNastavnikaForma":
                unosNastavnikaForma.setListaPredmetaPretraga(listaSvihPredmeta);
                unosNastavnikaForma.osveziTabele();
                break;
            case "izmenaNastavnikaForma":
                izmenaNastavnikaForma.setListaPredmetaPretraga(listaSvihPredmeta);
                izmenaNastavnikaForma.osveziTabele();
                break;

            default:
                setListaPredmetaPretraga(listaSvihPredmeta);
                gkf.osveziTabeluPredmeta();
        }

    }

    public void ispisiListuPredmeta(List<Predmet> listaPredmeta) {
        for (Predmet p : listaPredmeta) {
            System.out.println(p.getNaziv());
        }
    }

    public void pretraziPredmete(String nazivPredmeta) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.PRETRAZI_PREDMETE);
        Predmet predmet = new Predmet();
        predmet.setNaziv(nazivPredmeta);
        kz.setPredmet(predmet);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void vratiPodatkeOPredmetu(Predmet predmet) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_PODATKE_O_PREDMETU);
        kz.setPredmet(predmet);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziPodatkeOPredmetu(Predmet pronadjeniPredmet) {
        glavnaPredmetForma = new GlavnaPredmetForma();
        glavnaPredmetForma.setIzabraniPredmet(pronadjeniPredmet);
        glavnaPredmetForma.podesiFormu();

        gkf.setVisible(false);
        glavnaPredmetForma.setVisible(true);
    }

    public GlavnaPredmetForma getGlavnaPredmetForma() {
        return glavnaPredmetForma;
    }

    public void setGlavnaPredmetForma(GlavnaPredmetForma glavnaPredmetForma) {
        this.glavnaPredmetForma = glavnaPredmetForma;
    }

    public void prikaziGlavnuKlijentFormu(String forma) {
        switch (forma) {
            case "glavnaPredmetForma":
                glavnaPredmetForma.setVisible(false);
                break;
            case "glavnaNastavnikForma":
                glavnaNastavnikForma.setVisible(false);
                break;
            case "unosNastavnikaForma":
                unosNastavnikaForma.setVisible(false);
                break;
            case "unosPredmetaForma":
                unosPredmetaForma.setVisible(false);
                break;
            case "unosReferenceForma":
                unosReferenceForma.setVisible(false);
                break;
            case "izmenaPredmetaForma":
                izmenaPredmetaForma.setVisible(false);
                break;
            case "izmenaNastavnikaForma":
                izmenaNastavnikaForma.setVisible(false);
                break;
            default:
                break;
        }
        trenutnaForma = "glavnaKlijentForma";
        listaNastavnikaPretraga = new ArrayList<>();
        listaPredmetaPretraga = new ArrayList<>();
        gkf.osveziTabeluNastavnika();
        gkf.osveziTabeluPredmeta();
        gkf.setVisible(true);

    }

    public void vratiPodatkeONastavniku(Nastavnik izabraniNastavnik) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_PODATKE_O_NASTAVNIKU);
        kz.setNastavnik(izabraniNastavnik);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikazPodatkeONastavniku(Nastavnik pronadjeniNastavnik) {
        glavnaNastavnikForma = new GlavnaNastavnikForma();
        glavnaNastavnikForma.setNastavnik(pronadjeniNastavnik);

        glavnaNastavnikForma.podesiFormu();

        gkf.setVisible(false);
        glavnaNastavnikForma.setVisible(true);
    }

    public UnosNovogNastavnikaForma getUnosNastavnikaForma() {
        return unosNastavnikaForma;
    }

    public void setUnosNastavnikaForma(UnosNovogNastavnikaForma unosNastavnikaForma) {
        this.unosNastavnikaForma = unosNastavnikaForma;
    }

    public void prikaziFormuNastavnik(String forma) {
        if (forma.equals("glavnaKlijentForma")) {
            unosNastavnikaForma = new UnosNovogNastavnikaForma();
            unosNastavnikaForma.setListaTipovaNastavnika(listaTipovaNastavnika);
            unosNastavnikaForma.setListaTipovaUspeha(listaTipovaUspeha);
            unosNastavnikaForma.podesiFormu();
            trenutnaForma = "unosNastavnikaForma";
            gkf.setVisible(false);
            unosNastavnikaForma.setVisible(true);
        } else {
            izmenaNastavnikaForma = new IzmenaNastavnikaForma();

            izmenaNastavnikaForma.setNastavnik(nastavnikZaIzmenu);
            izmenaNastavnikaForma.setListaTipovaNastavnika(listaTipovaNastavnika);
            izmenaNastavnikaForma.setListaTipovaUspeha(listaTipovaUspeha);
            izmenaNastavnikaForma.popuniKopiju();
            izmenaNastavnikaForma.podesiFormu();
            trenutnaForma = "izmenaNastavnikaForma";
            glavnaNastavnikForma.setVisible(false);
            izmenaNastavnikaForma.setVisible(true);
        }

    }

    public void vratiSveTipoveNastavnika(String izvornaForma) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_TIPOVE_NASTAVNIKA);
        kz.setIzvornaForma(izvornaForma);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public List<TipNastavnika> getListaTipovaNastavnika() {
        return listaTipovaNastavnika;
    }

    public void setListaTipovaNastavnika(List<TipNastavnika> listaTipovaNastavnika) {
        this.listaTipovaNastavnika = listaTipovaNastavnika;
    }

    public void vratiSveTipoveUspeha(String izvornaForma) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_TIPOVE_USPEHA);
        kz.setIzvornaForma(izvornaForma);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void pretraziReference(String naslov, String forma) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.PRETRAZI_REFERENCE);
        Referenca r = new Referenca();
        r.setNaslov(naslov);
        kz.setIzvornaForma(forma);
        kz.setReferenca(r);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziReference(List<Referenca> listaPronadjenihReferenci, String forma) {
        if (forma.equals("unosNastavnikaForma")) {
            unosNastavnikaForma.setListaReferenciPretraga(listaPronadjenihReferenci);
            unosNastavnikaForma.osveziTabele();
        } else {
            izmenaNastavnikaForma.setListaReferenciPretraga(listaPronadjenihReferenci);
            izmenaNastavnikaForma.osveziTabele();
        }

    }

    public void unesiNastavnika(Nastavnik nastavnik) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.UNESI_NASTAVNIKA);
        kz.setNastavnik(nastavnik);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void vratiSveStudijskePrograme(String izvornaForma) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.VRATI_SVE_STUDIJSKE_PROGRAME);
        kz.setIzvornaForma(izvornaForma);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziFormuPredmet(String izvornaForma) {
        if (izvornaForma.equals("glavnaKlijentForma")) {
            unosPredmetaForma = new UnosNovogPredmetaForma();
            unosPredmetaForma.setListaStudijskihPrograma(listaStudijskiPrograma);

            unosPredmetaForma.podesiFormu();
            trenutnaForma = "unosPredmetaForma";
            gkf.setVisible(false);
            unosPredmetaForma.setVisible(true);
        } else {
            izmenaPredmetaForma = new IzmenaPredmetaForma();
            izmenaPredmetaForma.setPredmet(predmetZaIzmenu);
            izmenaPredmetaForma.popuniKopiju();
            izmenaPredmetaForma.setListaStudijskihPrograma(listaStudijskiPrograma);
            izmenaPredmetaForma.podesiFormu();
            trenutnaForma = "izmenaPredmetaForma";
            glavnaPredmetForma.setVisible(false);
            izmenaPredmetaForma.setVisible(true);
        }

    }

    public void unesiPredmet(Predmet predmet) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.UNESI_PREDMET);
        kz.setPredmet(predmet);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoUnetNastavnik(boolean uspesnoUnetNastavnik) {
        unosNastavnikaForma.uspesnoUnetNastavnik(uspesnoUnetNastavnik);
    }

    public void uspesnoUnetPredmet(boolean uspesnoUnetPredmet) {
        unosPredmetaForma.uspesnoUnetPredmet(uspesnoUnetPredmet);
    }

    public void dodajNovuReferencu() {
        unosReferenceForma = new UnosNoveReferenceForma();

        trenutnaForma = "unosReferenceForma";
        gkf.setVisible(false);
        unosReferenceForma.setVisible(true);
    }

    public void pretraziAutore(String imePrezime) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.PRETRAZI_AUTORE);
        SpoljniAutor sa = new SpoljniAutor();
        sa.setImePrezime(imePrezime);
        kz.setAutor(sa);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void prikaziAutore(List<SpoljniAutor> listaAutora) {
        unosReferenceForma.setListaAutoraPretraga(listaAutora);
        unosReferenceForma.osveziTabele();
    }

    public void unesiReferencu(Referenca referenca) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.UNESI_REFERENCU);
        kz.setReferenca(referenca);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoUnetaReferenca(boolean uspesnoUnetaReferenca) {
        unosReferenceForma.uspesnoUnetaReferenca(uspesnoUnetaReferenca);
    }

    public void obrisiPredmet(Predmet izabraniPredmet) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.OBRISI_PREDMET);
        kz.setPredmet(izabraniPredmet);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoObrisanPredmet(boolean uspesnoObrisanPredmet) {
        glavnaPredmetForma.uspesnoObrisanPredmet(uspesnoObrisanPredmet);
    }

    public void obrisiNastavnika(Nastavnik nastavnik) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.OBRISI_NASTAVNIKA);
        kz.setNastavnik(nastavnik);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoObrisanNastavnik(boolean uspesnoObrisanNastavnik) {
        glavnaNastavnikForma.uspesnoObrisanNastavnik(uspesnoObrisanNastavnik);
    }

    public void prikaziFormuZaIzmenuPredmeta(Predmet izabraniPredmet) {
        predmetZaIzmenu = izabraniPredmet;
        vratiSveStudijskePrograme("glavnaPredmetForma");
    }

    public void izmeniPredmet(Predmet predmet, List<StudijskiProgram> listaDodajStudijskiProgram, List<StudijskiProgram> listaObrisiStudijskiProgram, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.IZMENI_PREDMET);
        kz.setPredmet(predmet);
        kz.setListaDodajStudijskiProgram(listaDodajStudijskiProgram);
        kz.setListaObrisiStudijskiProgram(listaObrisiStudijskiProgram);
        kz.setListaDodajPredaje(listaDodajPredaje);
        kz.setListaObrisiPredaje(listaObrisiPredaje);
        kz.setListaIzmeniPredaje(listaIzmeniPredaje);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoIzmenjenPredmet(boolean uspesnoIzmenjenPredmet) {
        izmenaPredmetaForma.uspesnoSacuvanPredmet(uspesnoIzmenjenPredmet);
    }

    public void prikaziFormuZaIzmenuNastavnika(Nastavnik nastavnik) {
        nastavnikZaIzmenu = nastavnik;
        vratiSveTipoveNastavnika("glavnaNastavnikForma");
    }

    public void izmeniNastavnika(Nastavnik nastavnik, List<AkademskiUspeh> listaDodajAkademskiUspeh, List<AkademskiUspeh> listaObrisiAkademskiUspeh, List<Usavrsavanje> listaDodajUsavrsavanje, List<Usavrsavanje> listaObrisiUsavrsavanje, List<Referenca> listaDodajReferencu, List<Referenca> listaObrisiReferencu, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        KlijentZahtev kz = new KlijentZahtev();
        kz.setOperacija(Operacije.IZMENI_NASTAVNIKA);
        kz.setNastavnik(nastavnik);
        kz.setListaDodajAkademskiUspeh(listaDodajAkademskiUspeh);
        kz.setListaObrisiAkademskiUspeh(listaObrisiAkademskiUspeh);
        kz.setListaDodajUsavrsavanje(listaDodajUsavrsavanje);
        kz.setListaObrisiUsavrsavanje(listaObrisiUsavrsavanje);
        kz.setListaDodajReferencu(listaDodajReferencu);
        kz.setListaObrisiReferencu(listaObrisiReferencu);
        kz.setListaDodajPredaje(listaDodajPredaje);
        kz.setListaObrisiPredaje(listaObrisiPredaje);
        kz.setListaIzmeniPredaje(listaIzmeniPredaje);
        KomunikacijaKlijent.getInstance().posaljiZahtev(kz);
    }

    public void uspesnoIzmenjenNastavnik(boolean uspesnoIzmenjenNastavnik) {
        izmenaNastavnikaForma.uspesnoIzmenjenNastavnik(uspesnoIzmenjenNastavnik);
    }

    public void prikaziGlavnuNastavnikFormu() {
        izmenaNastavnikaForma.setVisible(false);
        glavnaNastavnikForma.setVisible(true);
    }

    public void prikaziGlavnuPredmetFormu() {
        izmenaPredmetaForma.setVisible(false);
        glavnaPredmetForma.setVisible(true);
    }

}
