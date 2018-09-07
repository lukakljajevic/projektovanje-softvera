/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import db.DBBroker;
import domen.Predmet;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class PretraziPredmete extends OpstaSO {

    public PretraziPredmete(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAllWhereLikeColumnsSingleJoinBasic((Predmet) object));
    }
    
}
