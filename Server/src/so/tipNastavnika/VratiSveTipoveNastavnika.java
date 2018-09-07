/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipNastavnika;

import db.DBBroker;
import domen.TipNastavnika;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class VratiSveTipoveNastavnika extends OpstaSO {

    public VratiSveTipoveNastavnika(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAll((TipNastavnika) object));
    }
    
}
