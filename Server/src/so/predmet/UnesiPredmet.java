/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import db.DBBroker;
import domen.Predaje;
import domen.Predmet;
import domen.PredmetStudijskiProgram;
import domen.StudijskiProgram;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class UnesiPredmet extends OpstaSO {

    public UnesiPredmet(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Predmet predmet = (Predmet) object;
        int predmetID = db.insert(predmet);
        predmet.setPredmetID(predmetID);

        for (StudijskiProgram sp : predmet.getListaStudijskihPrograma()) {
            PredmetStudijskiProgram psp = new PredmetStudijskiProgram(predmet, sp);
            db.insert(psp);
        }

        for (Predaje p : predmet.getListaPredavanja()) {
            p.setPredmet(predmet);
            db.insert(p);
        }
    }

}
