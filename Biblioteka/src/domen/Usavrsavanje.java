/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Usavrsavanje implements IDomen {
    private int usavrsavanjeID;
    private String naziv;
    private String institucija;
    private int godina;
    private Nastavnik nastavnik;
    
    public Usavrsavanje() {
    }

    public Usavrsavanje(int usavrsavanjeID, String naziv, String institucija, int godina, Nastavnik nastavnik) {
        this.usavrsavanjeID = usavrsavanjeID;
        this.naziv = naziv;
        this.institucija = institucija;
        this.godina = godina;
        this.nastavnik = nastavnik;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public int getUsavrsavanjeID() {
        return usavrsavanjeID;
    }

    public void setUsavrsavanjeID(int usavrsavanjeID) {
        this.usavrsavanjeID = usavrsavanjeID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    @Override
    public String getTableName() {
        return "usavrsavanje";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE nastavnikIDPK = " + nastavnik.getNastavnikID();
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "(nastavnikIDPK, naziv, institucija, godina)";
    }

    @Override
    public String getInsertValues() {
        return "(" + nastavnik.getNastavnikID() + ", '" + naziv + "', '" + institucija + "', " + godina + ")";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IDomen> getAllBasic(ResultSet rs) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        
        while (rs.next()) {
            Usavrsavanje u = new Usavrsavanje();
            Nastavnik n = new Nastavnik();
            u.setUsavrsavanjeID(rs.getInt("usavrsavanjeID"));
            n.setNastavnikID(rs.getInt("nastavnikIDPK"));
            u.setNastavnik(n);
            u.setNaziv(rs.getString("naziv"));
            u.setInstitucija(rs.getString("institucija"));
            u.setGodina(rs.getInt("godina"));
            
            vrati.add(u);
        }
        
        rs.close();
        return vrati;
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
        return "WHERE usavrsavanjeID = " + usavrsavanjeID;
    }
    
    
    
    
}
