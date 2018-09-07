/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.AkademskiUspeh;
import domen.Nastavnik;
import domen.Predaje;
import domen.Predmet;
import domen.Referenca;
import domen.SpoljniAutor;
import domen.StudijskiProgram;
import domen.Usavrsavanje;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Luka
 */
public class KlijentZahtev implements Serializable {
    private int operacija;
    private String username;
    private String password;
    private Nastavnik nastavnik;
    private Predmet predmet;
    private Referenca referenca;
    private SpoljniAutor autor;
    private String izvornaForma;
    private List<StudijskiProgram> listaDodajStudijskiProgram;
    private List<StudijskiProgram> listaObrisiStudijskiProgram;
    private List<Predaje> listaDodajPredaje;
    private List<Predaje> listaObrisiPredaje;
    private List<Predaje> listaIzmeniPredaje;
    private List<AkademskiUspeh> listaDodajAkademskiUspeh;
    private List<AkademskiUspeh> listaObrisiAkademskiUspeh;
    private List<Usavrsavanje> listaDodajUsavrsavanje;
    private List<Usavrsavanje> listaObrisiUsavrsavanje;
    private List<Referenca> listaDodajReferencu;
    private List<Referenca> listaObrisiReferencu;
    

    public String getIzvornaForma() {
        return izvornaForma;
    }

    public void setIzvornaForma(String izvornaForma) {
        this.izvornaForma = izvornaForma;
    }
    
    

    public SpoljniAutor getAutor() {
        return autor;
    }

    public void setAutor(SpoljniAutor autor) {
        this.autor = autor;
    }

    public Referenca getReferenca() {
        return referenca;
    }

    public void setReferenca(Referenca referenca) {
        this.referenca = referenca;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
    
    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public List<StudijskiProgram> getListaDodajStudijskiProgram() {
        return listaDodajStudijskiProgram;
    }

    public void setListaDodajStudijskiProgram(List<StudijskiProgram> listaDodajStudijskiProgram) {
        this.listaDodajStudijskiProgram = listaDodajStudijskiProgram;
    }

    public List<StudijskiProgram> getListaObrisiStudijskiProgram() {
        return listaObrisiStudijskiProgram;
    }

    public void setListaObrisiStudijskiProgram(List<StudijskiProgram> listaObrisiStudijskiProgram) {
        this.listaObrisiStudijskiProgram = listaObrisiStudijskiProgram;
    }

    public List<Predaje> getListaDodajPredaje() {
        return listaDodajPredaje;
    }

    public void setListaDodajPredaje(List<Predaje> listaDodajPredaje) {
        this.listaDodajPredaje = listaDodajPredaje;
    }

    public List<Predaje> getListaObrisiPredaje() {
        return listaObrisiPredaje;
    }

    public void setListaObrisiPredaje(List<Predaje> listaObrisiPredaje) {
        this.listaObrisiPredaje = listaObrisiPredaje;
    }

    public List<Predaje> getListaIzmeniPredaje() {
        return listaIzmeniPredaje;
    }

    public void setListaIzmeniPredaje(List<Predaje> listaIzmeniPredaje) {
        this.listaIzmeniPredaje = listaIzmeniPredaje;
    }

    public List<AkademskiUspeh> getListaDodajAkademskiUspeh() {
        return listaDodajAkademskiUspeh;
    }

    public void setListaDodajAkademskiUspeh(List<AkademskiUspeh> listaDodajAkademskiUspeh) {
        this.listaDodajAkademskiUspeh = listaDodajAkademskiUspeh;
    }

    public List<AkademskiUspeh> getListaObrisiAkademskiUspeh() {
        return listaObrisiAkademskiUspeh;
    }

    public void setListaObrisiAkademskiUspeh(List<AkademskiUspeh> listaObrisiAkademskiUspeh) {
        this.listaObrisiAkademskiUspeh = listaObrisiAkademskiUspeh;
    }

    public List<Usavrsavanje> getListaDodajUsavrsavanje() {
        return listaDodajUsavrsavanje;
    }

    public void setListaDodajUsavrsavanje(List<Usavrsavanje> listaDodajUsavrsavanje) {
        this.listaDodajUsavrsavanje = listaDodajUsavrsavanje;
    }

    public List<Usavrsavanje> getListaObrisiUsavrsavanje() {
        return listaObrisiUsavrsavanje;
    }

    public void setListaObrisiUsavrsavanje(List<Usavrsavanje> listaObrisiUsavrsavanje) {
        this.listaObrisiUsavrsavanje = listaObrisiUsavrsavanje;
    }

    public List<Referenca> getListaDodajReferencu() {
        return listaDodajReferencu;
    }

    public void setListaDodajReferencu(List<Referenca> listaDodajReferencu) {
        this.listaDodajReferencu = listaDodajReferencu;
    }

    public List<Referenca> getListaObrisiReferencu() {
        return listaObrisiReferencu;
    }

    public void setListaObrisiReferencu(List<Referenca> listaObrisiReferencu) {
        this.listaObrisiReferencu = listaObrisiReferencu;
    }
    
    
    
}
