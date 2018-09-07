/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.Nastavnik;
import domen.Predmet;
import domen.Referenca;
import domen.SpoljniAutor;
import domen.StudijskiProgram;
import domen.TipNastavnika;
import domen.TipUspeha;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Luka
 */
public class ServerOdgovor implements Serializable {
    private int operacija;
    private boolean ulogovan;
    private String poruka;
    private List<Nastavnik> listaNastavnika;
    private List<Predmet> listaPredmeta;
    private Predmet predmet;
    private Nastavnik nastavnik;
    private List<TipNastavnika> listaTipovaNastavnika;
    private List<TipUspeha> listaTipovaUspeha;
    private List<Referenca> listaReferenci;
    private boolean uspesnoUnetNastavnik;
    private List<StudijskiProgram> listaStudijskihPrograma;
    private boolean uspesnoUnetPredmet;
    private List<SpoljniAutor> listaAutora;
    private boolean uspesnoUnetaReferenca;
    private boolean uspesnoObrisanPredmet;
    private boolean uspesnoObrisanNastavnik;
    private String izvornaForma;
    private boolean uspesnoIzmenjenPredmet;
    private boolean uspesnoIzmenjenNastavnik;

    public boolean isUspesnoIzmenjenNastavnik() {
        return uspesnoIzmenjenNastavnik;
    }

    public void setUspesnoIzmenjenNastavnik(boolean uspesnoIzmenjenNastavnik) {
        this.uspesnoIzmenjenNastavnik = uspesnoIzmenjenNastavnik;
    }
    
    

    public String getIzvornaForma() {
        return izvornaForma;
    }

    public void setIzvornaForma(String izvornaForma) {
        this.izvornaForma = izvornaForma;
    }

    public boolean isUspesnoUnetaReferenca() {
        return uspesnoUnetaReferenca;
    }

    public void setUspesnoUnetaReferenca(boolean uspesnoUnetaReferenca) {
        this.uspesnoUnetaReferenca = uspesnoUnetaReferenca;
    }
    

    public List<SpoljniAutor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<SpoljniAutor> listaAutora) {
        this.listaAutora = listaAutora;
    }
    

    public boolean isUspesnoUnetPredmet() {
        return uspesnoUnetPredmet;
    }

    public void setUspesnoUnetPredmet(boolean uspesnoUnetPredmet) {
        this.uspesnoUnetPredmet = uspesnoUnetPredmet;
    }

    public List<StudijskiProgram> getListaStudijskihPrograma() {
        return listaStudijskihPrograma;
    }

    public void setListaStudijskihPrograma(List<StudijskiProgram> listaStudijskihPrograma) {
        this.listaStudijskihPrograma = listaStudijskihPrograma;
    }

    public boolean isUspesnoUnetNastavnik() {
        return uspesnoUnetNastavnik;
    }

    public void setUspesnoUnetNastavnik(boolean uspesnoUnetNastavnik) {
        this.uspesnoUnetNastavnik = uspesnoUnetNastavnik;
    }

    public List<Referenca> getListaReferenci() {
        return listaReferenci;
    }

    public void setListaReferenci(List<Referenca> listaReferenci) {
        this.listaReferenci = listaReferenci;
    }

    public List<TipUspeha> getListaTipovaUspeha() {
        return listaTipovaUspeha;
    }

    public void setListaTipovaUspeha(List<TipUspeha> listaTipovaUspeha) {
        this.listaTipovaUspeha = listaTipovaUspeha;
    }

    public List<TipNastavnika> getListaTipovaNastavnika() {
        return listaTipovaNastavnika;
    }

    public void setListaTipovaNastavnika(List<TipNastavnika> listaTipovaNastavnika) {
        this.listaTipovaNastavnika = listaTipovaNastavnika;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public List<Predmet> getListaPredmeta() {
        return listaPredmeta;
    }

    public void setListaPredmeta(List<Predmet> listaPredmeta) {
        this.listaPredmeta = listaPredmeta;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public List<Nastavnik> getListaNastavnika() {
        return listaNastavnika;
    }

    public void setListaNastavnika(List<Nastavnik> listaNastavnika) {
        this.listaNastavnika = listaNastavnika;
    }

    public boolean isUspesnoObrisanPredmet() {
        return uspesnoObrisanPredmet;
    }

    public void setUspesnoObrisanPredmet(boolean uspesnoObrisanPredmet) {
        this.uspesnoObrisanPredmet = uspesnoObrisanPredmet;
    }

    public boolean isUspesnoObrisanNastavnik() {
        return uspesnoObrisanNastavnik;
    }

    public void setUspesnoObrisanNastavnik(boolean uspesnoObrisanNastavnik) {
        this.uspesnoObrisanNastavnik = uspesnoObrisanNastavnik;
    }

    public boolean isUspesnoIzmenjenPredmet() {
        return uspesnoIzmenjenPredmet;
    }

    public void setUspesnoIzmenjenPredmet(boolean uspesnoIzmenjenPredmet) {
        this.uspesnoIzmenjenPredmet = uspesnoIzmenjenPredmet;
    }
    
    
    
    
    
}
