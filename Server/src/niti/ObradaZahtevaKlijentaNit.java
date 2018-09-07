/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Nastavnik;
import domen.Predmet;
import domen.Referenca;
import domen.SpoljniAutor;
import domen.StudijskiProgram;
import domen.TipNastavnika;
import domen.TipUspeha;
import java.net.Socket;
import java.util.List;
import komunikacija.KomunikacijaServer;
import kontroler.KontrolerServer;
import operacije.Operacije;
import transfer.KlijentZahtev;
import transfer.ServerOdgovor;


/**
 *
 * @author Luka
 */
public class ObradaZahtevaKlijentaNit extends Thread {

    Socket socket;

    public ObradaZahtevaKlijentaNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed() && socket != null) {
                KlijentZahtev kz = KomunikacijaServer.getInstance().primiZahtevOdKlijenta(socket);
                ServerOdgovor so = new ServerOdgovor();

                switch (kz.getOperacija()) {
                    case Operacije.LOGIN:
                        so.setOperacija(Operacije.LOGIN);
                        String username = kz.getUsername();
                        String password = kz.getPassword();
                        if (KontrolerServer.getInstance().ulogujKorisnika(username, password, socket)) {
                            so.setUlogovan(true);
                        } else {
                            so.setUlogovan(false);
                        }
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_SVE_NASTAVNIKE:
                        List<Nastavnik> listaSvihNastavnika = KontrolerServer.getInstance().vratiSveNastavnike();
                        so.setOperacija(Operacije.VRATI_SVE_NASTAVNIKE);
                        so.setListaNastavnika(listaSvihNastavnika);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.PRETRAZI_NASTAVNIKE:
                        List<Nastavnik> listaNastavnikaPretraga = KontrolerServer.getInstance().pretraziNastavnike(kz.getNastavnik());
                        so.setOperacija(Operacije.PRETRAZI_NASTAVNIKE);
                        so.setListaNastavnika(listaNastavnikaPretraga);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_SVE_PREDMETE:
                        List<Predmet> listaSvihPredmeta = KontrolerServer.getInstance().vratiSvePredmete();
                        so.setOperacija(Operacije.VRATI_SVE_PREDMETE);
                        so.setListaPredmeta(listaSvihPredmeta);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.PRETRAZI_PREDMETE:
                        List<Predmet> listaPredmetaPretraga = KontrolerServer.getInstance().pretraziPredmete(kz.getPredmet());
                        so.setOperacija(Operacije.PRETRAZI_PREDMETE);
                        so.setListaPredmeta(listaPredmetaPretraga);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_PODATKE_O_PREDMETU:
                        Predmet pronadjeniPredmet = KontrolerServer.getInstance().vratiPodatkeOPredmetu(kz.getPredmet());
                        so.setOperacija(Operacije.VRATI_PODATKE_O_PREDMETU);
                        so.setPredmet(pronadjeniPredmet);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_PODATKE_O_NASTAVNIKU:
                        Nastavnik pronadjeniNastavnik = KontrolerServer.getInstance().vratiPodatkeONastavniku(kz.getNastavnik());
                        so.setOperacija(Operacije.VRATI_PODATKE_O_NASTAVNIKU);
                        so.setNastavnik(pronadjeniNastavnik);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_SVE_TIPOVE_NASTAVNIKA:
                        List<TipNastavnika> listaSvihTipovaNastavnika = KontrolerServer.getInstance().vratiSveTipoveNastavnika();
                        so.setOperacija(Operacije.VRATI_SVE_TIPOVE_NASTAVNIKA);
                        so.setIzvornaForma(kz.getIzvornaForma());
                        so.setListaTipovaNastavnika(listaSvihTipovaNastavnika);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_SVE_TIPOVE_USPEHA:
                        List<TipUspeha> listaSvihTipovaUspeha = KontrolerServer.getInstance().vratiSveTipoveUspeha();
                        so.setOperacija(Operacije.VRATI_SVE_TIPOVE_USPEHA);
                        so.setIzvornaForma(kz.getIzvornaForma());
                        so.setListaTipovaUspeha(listaSvihTipovaUspeha);
                        
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.PRETRAZI_REFERENCE:
                        List<Referenca> listaPronadjenihReferenci = KontrolerServer.getInstance().pretraziReference(kz.getReferenca());
                        so.setOperacija(Operacije.PRETRAZI_REFERENCE);
                        so.setIzvornaForma(kz.getIzvornaForma());
                        so.setListaReferenci(listaPronadjenihReferenci);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.UNESI_NASTAVNIKA:
                        so.setOperacija(Operacije.UNESI_NASTAVNIKA);
                        so.setUspesnoUnetNastavnik(KontrolerServer.getInstance().unesiNastavnika(kz.getNastavnik()));
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.VRATI_SVE_STUDIJSKE_PROGRAME:
                        List<StudijskiProgram> listaSvihStudijskihPrograma = KontrolerServer.getInstance().vratiSveStudijskePrograme();
                        so.setOperacija(Operacije.VRATI_SVE_STUDIJSKE_PROGRAME);
                        so.setListaStudijskihPrograma(listaSvihStudijskihPrograma);
                        so.setIzvornaForma(kz.getIzvornaForma());
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.UNESI_PREDMET:
                        so.setOperacija(Operacije.UNESI_PREDMET);
                        so.setUspesnoUnetPredmet(KontrolerServer.getInstance().unesiPredmet(kz.getPredmet()));
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.PRETRAZI_AUTORE:
                        List<SpoljniAutor> listaPronadjenihAutora = KontrolerServer.getInstance().pretraziAutore(kz.getAutor());
                        so.setOperacija(Operacije.PRETRAZI_AUTORE);
                        so.setListaAutora(listaPronadjenihAutora);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.UNESI_REFERENCU:
                        so.setUspesnoUnetaReferenca(KontrolerServer.getInstance().unesiReferencu(kz.getReferenca()));
                        so.setOperacija(Operacije.UNESI_REFERENCU);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.OBRISI_PREDMET:
                        so.setUspesnoObrisanPredmet(KontrolerServer.getInstance().obrisiPredmet(kz.getPredmet()));
                        so.setOperacija(Operacije.OBRISI_PREDMET);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.OBRISI_NASTAVNIKA:
                        so.setUspesnoObrisanNastavnik(KontrolerServer.getInstance().obrisiNastavnika(kz.getNastavnik()));
                        so.setOperacija(Operacije.OBRISI_NASTAVNIKA);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.IZMENI_PREDMET:
                        so.setUspesnoIzmenjenPredmet(KontrolerServer.getInstance().izmeniPredmet(kz.getPredmet(), kz.getListaDodajStudijskiProgram(), kz.getListaObrisiStudijskiProgram(), kz.getListaDodajPredaje(), kz.getListaObrisiPredaje(), kz.getListaIzmeniPredaje()));
                        so.setOperacija(Operacije.IZMENI_PREDMET);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                    case Operacije.IZMENI_NASTAVNIKA:
                        so.setUspesnoIzmenjenNastavnik(KontrolerServer.getInstance().izmeniNastavnika(kz.getNastavnik(), kz.getListaDodajAkademskiUspeh(), kz.getListaObrisiAkademskiUspeh(), kz.getListaDodajUsavrsavanje(), kz.getListaObrisiUsavrsavanje(), kz.getListaDodajReferencu(), kz.getListaObrisiReferencu(), kz.getListaDodajPredaje(), kz.getListaObrisiPredaje(), kz.getListaIzmeniPredaje()));
                        so.setOperacija(Operacije.IZMENI_NASTAVNIKA);
                        KomunikacijaServer.getInstance().posaljiOdgovorKljientu(socket, so);
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Soket zatvoren!");
            this.interrupt();
            return;
        }
    }

}
