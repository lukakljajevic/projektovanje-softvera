/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.studijskiProgram;

import db.DBBroker;
import domen.StudijskiProgram;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class VratiSveStudijskePrograme extends OpstaSO {

    public VratiSveStudijskePrograme(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        setObject(db.getAll((StudijskiProgram) object));
    }
    
}
