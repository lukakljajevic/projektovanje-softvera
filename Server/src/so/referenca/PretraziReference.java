/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.referenca;

import db.DBBroker;
import domen.Referenca;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class PretraziReference extends OpstaSO {

    public PretraziReference(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAllWhereLikeColumnsSingleJoinAll((Referenca) object));
        
    }
    
}
