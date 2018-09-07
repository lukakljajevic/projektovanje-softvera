/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Nastavnik;
import domen.Predmet;
import domen.Referenca;
import domen.StudijskiProgram;
import domen.TipNastavnika;
import domen.TipUspeha;
import java.util.List;
import komunikacija.KomunikacijaKlijent;
import konstante.Konstante;
import kontroler.KontrolerKlijent;
import operacije.Operacije;
import transfer.ServerOdgovor;

/**
 *
 * @author Luka
 */
public class ObradaOdgovoraServeraNit extends Thread {
    @Override
    public void run() {
        while(true) {
            
            ServerOdgovor so = KomunikacijaKlijent.getInstance().primiOdgovor();
            
            switch(so.getOperacija()) {
                case Operacije.LOGIN:
                    KontrolerKlijent.getInstance().uspesnoUlogovan(so.isUlogovan());
                    break;
                case Operacije.LOGOUT:
                    switch (KontrolerKlijent.getInstance().getTrenutnaForma()) {
                        case "glavna":
                            KontrolerKlijent.getInstance().logoutGlavnaForma();
                            break;
                        default:
                            break;
                    }
                    break;
                case Operacije.VRATI_SVE_NASTAVNIKE:
                    List<Nastavnik> lista = so.getListaNastavnika();
                    KontrolerKlijent.getInstance().prikaziSveNastavnike(lista, KontrolerKlijent.getInstance().getTrenutnaForma());
                    break;
                case Operacije.PRETRAZI_NASTAVNIKE:
                    List<Nastavnik> listaNastavnikaPretraga = so.getListaNastavnika();
                    KontrolerKlijent.getInstance().prikaziSveNastavnike(listaNastavnikaPretraga, KontrolerKlijent.getInstance().getTrenutnaForma());
                    break;
                case Operacije.VRATI_SVE_PREDMETE:
                    List<Predmet> listaSvihPredmeta = so.getListaPredmeta();
                    KontrolerKlijent.getInstance().prikaziPredmete(listaSvihPredmeta, KontrolerKlijent.getInstance().getTrenutnaForma());
                    break;
                case Operacije.PRETRAZI_PREDMETE:
                    List<Predmet> listaPredmetaPretraga = so.getListaPredmeta();
                    KontrolerKlijent.getInstance().prikaziPredmete(listaPredmetaPretraga, KontrolerKlijent.getInstance().getTrenutnaForma());
                    break;
                case Operacije.VRATI_PODATKE_O_PREDMETU:
                    Predmet pronadjeniPredmet = so.getPredmet();
                    KontrolerKlijent.getInstance().prikaziPodatkeOPredmetu(pronadjeniPredmet);
                    break;
                case Operacije.VRATI_PODATKE_O_NASTAVNIKU:
                    Nastavnik pronadjeniNastavnik = so.getNastavnik();
                    KontrolerKlijent.getInstance().prikazPodatkeONastavniku(pronadjeniNastavnik);
                    break;
                case Operacije.VRATI_SVE_TIPOVE_NASTAVNIKA:
                    List<TipNastavnika> listaSvihTipovaNastavnika = so.getListaTipovaNastavnika();
                    KontrolerKlijent.getInstance().setListaTipovaNastavnika(listaSvihTipovaNastavnika);
                    KontrolerKlijent.getInstance().vratiSveTipoveUspeha(so.getIzvornaForma());
                    break;
                case Operacije.VRATI_SVE_TIPOVE_USPEHA:
                    List<TipUspeha> listaSvihTipovaUspeha = so.getListaTipovaUspeha();
                    KontrolerKlijent.getInstance().setListaTipovaUspeha(listaSvihTipovaUspeha);
                    KontrolerKlijent.getInstance().prikaziFormuNastavnik(so.getIzvornaForma());
                    break;
                case Operacije.PRETRAZI_REFERENCE:
                    List<Referenca> listaPronadjenihReferenci = so.getListaReferenci();
                    KontrolerKlijent.getInstance().prikaziReference(listaPronadjenihReferenci, so.getIzvornaForma());
                    break;
                case Operacije.VRATI_SVE_STUDIJSKE_PROGRAME:
                    KontrolerKlijent.getInstance().setListaStudijskiPrograma(so.getListaStudijskihPrograma());
                    KontrolerKlijent.getInstance().prikaziFormuPredmet(so.getIzvornaForma());
                    break;
                case Operacije.UNESI_NASTAVNIKA:
                    KontrolerKlijent.getInstance().uspesnoUnetNastavnik(so.isUspesnoUnetNastavnik());
                    break;
                case Operacije.UNESI_PREDMET:
                    KontrolerKlijent.getInstance().uspesnoUnetPredmet(so.isUspesnoUnetPredmet());
                    break;
                case Operacije.PRETRAZI_AUTORE:
                    KontrolerKlijent.getInstance().prikaziAutore(so.getListaAutora());
                    break;
                case Operacije.UNESI_REFERENCU:
                    KontrolerKlijent.getInstance().uspesnoUnetaReferenca(so.isUspesnoUnetaReferenca());
                    break;
                case Operacije.OBRISI_PREDMET:
                    KontrolerKlijent.getInstance().uspesnoObrisanPredmet(so.isUspesnoObrisanPredmet());
                    break;
                case Operacije.OBRISI_NASTAVNIKA:
                    KontrolerKlijent.getInstance().uspesnoObrisanNastavnik(so.isUspesnoObrisanNastavnik());
                    break;
                case Operacije.IZMENI_PREDMET:
                    KontrolerKlijent.getInstance().uspesnoIzmenjenPredmet(so.isUspesnoIzmenjenPredmet());
                    break;
                case Operacije.IZMENI_NASTAVNIKA:
                    KontrolerKlijent.getInstance().uspesnoIzmenjenNastavnik(so.isUspesnoIzmenjenNastavnik());
                    break;
            }
        }
    }
}
