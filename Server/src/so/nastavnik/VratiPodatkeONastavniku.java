/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nastavnik;

import db.DBBroker;
import domen.AkademskiUspeh;
import domen.Nastavnik;
import domen.Referenca;
import domen.Usavrsavanje;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class VratiPodatkeONastavniku extends OpstaSO {

    public VratiPodatkeONastavniku(Object object, DBBroker db) {
        super(object, db);
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        

        Nastavnik n = (Nastavnik) db.getOneWhereEqualsColumnsSingleJoinColumnsAll((Nastavnik) object);
        
        // Vrati nastavnike za sve reference
        for (Referenca r : n.getListaReferenci()) {
            Referenca vracenaReferenca = (Referenca) db.getOneWhereEqualsColumnsSingleJoinColumnsBasic(r);
            dodajNastavnikeUReferencu(n, vracenaReferenca);
        }

        // Vrati akademske uspehe
        AkademskiUspeh primerUspeha = new AkademskiUspeh();
        primerUspeha.setNastavnik(n);
        Object vracenaListaUspeha = db.getAllWhereEqualsColumnsSingleJoinColumnsBasic(primerUspeha);;
        
        
        n.setListaAkademskihUspeha((List<AkademskiUspeh>) vracenaListaUspeha);

        // Vrati usavrsavanja
        Usavrsavanje primerUsavrsavanja = new Usavrsavanje();
        primerUsavrsavanja.setNastavnik(n);
        
        Object vracenaListaUsavrsavanja = db.getAllWhereEqualsColumnsSingle(primerUsavrsavanja);
        n.setListaUsavrsavanja((List<Usavrsavanje>) vracenaListaUsavrsavanja);
        
        setObject(n);
    }
    
    private void dodajNastavnikeUReferencu(Nastavnik n, Referenca vracenaReferenca) {
        for (Referenca r : n.getListaReferenci()) {
            if (r.getReferencaID() == vracenaReferenca.getReferencaID()) {
                r.setListaNastavnika(vracenaReferenca.getListaNastavnika());
            }
        }
    }

}
