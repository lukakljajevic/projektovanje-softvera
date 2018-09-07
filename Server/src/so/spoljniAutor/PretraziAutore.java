/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.spoljniAutor;

import db.DBBroker;
import domen.SpoljniAutor;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class PretraziAutore extends OpstaSO {

    public PretraziAutore(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAllWhereLikeColumnsSingle((SpoljniAutor) object));
    }
    
}
