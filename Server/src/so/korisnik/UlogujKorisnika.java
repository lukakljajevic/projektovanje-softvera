/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import db.DBBroker;
import domen.IDomen;
import domen.Korisnik;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class UlogujKorisnika extends OpstaSO {

    public UlogujKorisnika(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Korisnik k = (Korisnik) object;
        String[] kolone = { "username", "password" };
        String[] vrednosti = { k.getUsername(), k.getPassword() };
        setObject((Korisnik) db.vratiObjekatPoViseKriterijumaJednako((IDomen) k, kolone, vrednosti));
//        System.out.println(object);
    }
    
}
