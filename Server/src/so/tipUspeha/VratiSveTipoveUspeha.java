/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipUspeha;

import db.DBBroker;
import domen.TipUspeha;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class VratiSveTipoveUspeha extends OpstaSO {

    public VratiSveTipoveUspeha(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAll(new TipUspeha()));
    }
    
}
