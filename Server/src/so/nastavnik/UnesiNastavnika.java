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
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class UnesiNastavnika extends OpstaSO {

    public UnesiNastavnika(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {

        Nastavnik nastavnik = (Nastavnik) object;

        int id = db.insert(nastavnik);
        nastavnik.setNastavnikID(id);

        for (Referenca r : nastavnik.getListaReferenci()) {
            ReferencaNastavnik rn = new ReferencaNastavnik(r, nastavnik);
            db.insert(rn);
        }

        for (Predaje p : nastavnik.getListaPredavanja()) {
            p.setNastavnik(nastavnik);
            db.insert(p);
        }

        for (Usavrsavanje u : nastavnik.getListaUsavrsavanja()) {
            u.setNastavnik(nastavnik);
            db.insert(u);
        }

        for (AkademskiUspeh au : nastavnik.getListaAkademskihUspeha()) {
            au.setNastavnik(nastavnik);
            db.insert(au);
        }
    }

}
