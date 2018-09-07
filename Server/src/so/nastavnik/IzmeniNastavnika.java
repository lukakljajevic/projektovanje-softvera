/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nastavnik;

import db.DBBroker;
import domen.AkademskiUspeh;
import domen.Nastavnik;
import domen.Predaje;
import domen.Referenca;
import domen.ReferencaNastavnik;
import domen.Usavrsavanje;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class IzmeniNastavnika extends OpstaSO {

    List<AkademskiUspeh> listaDodajAkademskiUspeh;
    List<AkademskiUspeh> listaObrisiAkademskiUspeh;
    List<Usavrsavanje> listaDodajUsavrsavanje;
    List<Usavrsavanje> listaObrisiUsavrsavanje;
    List<Referenca> listaDodajReferencu;
    List<Referenca> listaObrisiReferencu;
    List<Predaje> listaDodajPredaje;
    List<Predaje> listaObrisiPredaje;
    List<Predaje> listaIzmeniPredaje;

    public IzmeniNastavnika(Object object, DBBroker db, List<AkademskiUspeh> listaDodajAkademskiUspeh, List<AkademskiUspeh> listaObrisiAkademskiUspeh, List<Usavrsavanje> listaDodajUsavrsavanje, List<Usavrsavanje> listaObrisiUsavrsavanje, List<Referenca> listaDodajReferencu, List<Referenca> listaObrisiReferencu, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        super(object, db);

        this.listaDodajAkademskiUspeh = listaDodajAkademskiUspeh;
        this.listaObrisiAkademskiUspeh = listaObrisiAkademskiUspeh;
        this.listaDodajUsavrsavanje = listaDodajUsavrsavanje;
        this.listaObrisiUsavrsavanje = listaObrisiUsavrsavanje;
        this.listaDodajReferencu = listaDodajReferencu;
        this.listaObrisiReferencu = listaObrisiReferencu;
        this.listaDodajPredaje = listaDodajPredaje;
        this.listaObrisiPredaje = listaObrisiPredaje;
        this.listaIzmeniPredaje = listaIzmeniPredaje;

    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Nastavnik nastavnik = (Nastavnik) object;
        db.updateWhereEqualsColumnSingle(nastavnik);
        
        for (AkademskiUspeh au : listaDodajAkademskiUspeh) {
            au.setNastavnik(nastavnik);
            db.insert(au);
        }
        
        for (AkademskiUspeh au : listaObrisiAkademskiUspeh) {
            db.deleteWhereEqualsColumnSingle2(au);
        }
        
        for (Usavrsavanje u : listaDodajUsavrsavanje) {
            u.setNastavnik(nastavnik);
            db.insert(u);
        }
        
        for (Usavrsavanje u : listaObrisiUsavrsavanje) {
            db.deleteWhereEqualsColumnSingle2(u);
        }
        
        for (Referenca r : listaDodajReferencu) {
            ReferencaNastavnik rn = new ReferencaNastavnik(r, nastavnik);
            db.insert(rn);
        }
        
        for (Referenca r : listaObrisiReferencu) {
            ReferencaNastavnik rn = new ReferencaNastavnik(r, nastavnik);
            db.deleteWhereEqualsColumnMultiple(rn);
        }
        
        for (Predaje p : listaDodajPredaje) {
            p.setNastavnik(nastavnik);
            db.insert(p);
        }
        
        for (Predaje p : listaObrisiPredaje) {
            p.setNastavnik(nastavnik);
            db.deleteWhereEqualsColumnMultiple(p);
        }
        
        for (Predaje p : listaIzmeniPredaje) {
            p.setNastavnik(nastavnik);
            db.updateWhereEqualsColumnMultiple(p);
        }
        
    }

}
