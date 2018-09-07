/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nastavnik;

import db.DBBroker;
import domen.Nastavnik;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class VratiSveNastavnike extends OpstaSO {

    public VratiSveNastavnike(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAllJoinBasic((Nastavnik) object));
    }
    
}
