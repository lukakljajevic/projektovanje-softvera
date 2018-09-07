/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.referenca;

import db.DBBroker;
import domen.Nastavnik;
import domen.Referenca;
import domen.ReferencaNastavnik;
import domen.ReferencaSpoljniAutor;
import domen.SpoljniAutor;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class UnesiReferencu extends OpstaSO {

    public UnesiReferencu(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Referenca referenca = (Referenca) object;
        int referencaID = db.insert(referenca);
        referenca.setReferencaID(referencaID);

        for (Nastavnik n : referenca.getListaNastavnika()) {
            ReferencaNastavnik rn = new ReferencaNastavnik(referenca, n);
            db.insert(rn);
        }

        for (SpoljniAutor sa : referenca.getListaSpoljnihAutora()) {
            ReferencaSpoljniAutor rsa = new ReferencaSpoljniAutor(referenca, sa);
            db.insert(rsa);
        }
    }

}
