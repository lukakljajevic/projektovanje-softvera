/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Predaje implements IDomen {
    private Nastavnik nastavnik;
    private Predmet predmet;
    private int brojCasova;

    public Predaje() {
    }

    public Predaje(Nastavnik nastavnik, Predmet predmet, int brojCasova) {
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.brojCasova = brojCasova;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public int getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    @Override
    public String getTableName() {
        return "predaje";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE predmetIDPredaje = " + predmet.getPredmetID();
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        return "WHERE nastavnikIDPredaje = " + nastavnik.getNastavnikID() + " AND predmetIDPredaje = " + predmet.getPredmetID();
    }

    @Override
    public String getWhereLikeColumnsSingle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereLikeColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinColumnsBasic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinColumnsAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertColumns() {
        return "(nastavnikIDPredaje, predmetIDPredaje, brojCasova)";
    }

    @Override
    public String getInsertValues() {
        return "(" + nastavnik.getNastavnikID() + ", " + predmet.getPredmetID() + ", " + brojCasova + ")";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        return "brojCasova = " + brojCasova;
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IDomen> getAllBasic(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IDomen> getAllFull(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAfterInsert(ResultSet rs) throws Exception {
        return 0;
    }

    @Override
    public String getOrderByColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereEqualsColumnsSingle2() {
        return "WHERE nastavnikIDPredaje = " + nastavnik.getNastavnikID();
    }

    
    
    
    
}
