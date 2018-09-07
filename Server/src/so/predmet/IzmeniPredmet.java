/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import db.DBBroker;
import domen.Predaje;
import domen.Predmet;
import domen.PredmetStudijskiProgram;
import domen.StudijskiProgram;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Luka
 */
public class IzmeniPredmet extends OpstaSO {
    List<StudijskiProgram> listaDodajStudijskiProgram;
    List<StudijskiProgram> listaObrisiStudijskiProgram;
    List<Predaje> listaDodajPredaje;
    List<Predaje> listaObrisiPredaje;
    List<Predaje> listaIzmeniPredaje;

    public IzmeniPredmet(Object object, DBBroker db, List<StudijskiProgram> listaDodajStudijskiProgram, List<StudijskiProgram> listaObrisiStudijskiProgram, List<Predaje> listaDodajPredaje, List<Predaje> listaObrisiPredaje, List<Predaje> listaIzmeniPredaje) {
        super(object, db);
        this.listaDodajStudijskiProgram = listaDodajStudijskiProgram;
        this.listaObrisiStudijskiProgram = listaObrisiStudijskiProgram;
        this.listaDodajPredaje = listaDodajPredaje;
        this.listaObrisiPredaje = listaObrisiPredaje;
        this.listaIzmeniPredaje = listaIzmeniPredaje;
    }

    @Override
    protected void izvrsiOperaciju(Object object) throws Exception {
        Predmet predmet = (Predmet) object;
        db.updateWhereEqualsColumnSingle(predmet);
        
        for (StudijskiProgram sp : listaDodajStudijskiProgram) {
            PredmetStudijskiProgram psp = new PredmetStudijskiProgram(predmet, sp);
            db.insert(psp);
        }
        
        for (StudijskiProgram sp : listaObrisiStudijskiProgram) {
            PredmetStudijskiProgram psp = new PredmetStudijskiProgram(predmet, sp);
            db.deleteWhereEqualsColumnMultiple(psp);
        }
        
        for (Predaje p : listaDodajPredaje) {
            db.insert(p);
        }
        
        for (Predaje p : listaObrisiPredaje) {
            p.setPredmet(predmet);
            db.deleteWhereEqualsColumnMultiple(p);
        }
        
        for (Predaje p : listaIzmeniPredaje) {
            p.setPredmet(predmet);
            db.updateWhereEqualsColumnMultiple(p);
        }
    }
    
}
