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
public class AkademskiUspeh implements IDomen {
    private int uspehID;
    private int godina;
    private String institucija;
    private String oblast;
    private TipUspeha tipUspeha;
    private Nastavnik nastavnik;

    public AkademskiUspeh() {
    }

    public AkademskiUspeh(int uspehID, int godina, String institucija, String oblast, TipUspeha tipUspeha, Nastavnik nastavnik) {
        this.uspehID = uspehID;
        this.godina = godina;
        this.institucija = institucija;
        this.oblast = oblast;
        this.tipUspeha = tipUspeha;
        this.nastavnik = nastavnik;
    }

    public TipUspeha getTipUspeha() {
        return tipUspeha;
    }

    public void setTipUspeha(TipUspeha tipUspeha) {
        this.tipUspeha = tipUspeha;
    }

    public int getUspehID() {
        return uspehID;
    }

    public void setUspehID(int uspehID) {
        this.uspehID = uspehID;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    public String getOblast() {
        return oblast;
    }

    public void setOblast(String oblast) {
        this.oblast = oblast;
    }
    
    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    @Override
    public String getTableName() {
        return "`akademski-uspeh`";
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
        return "JOIN `tip-uspeha` ON tipIDFK = tipUspehaID";
    }

    @Override
    public String getJoinColumnsAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertColumns() {
        return "(nastavnikIDPK, godina, institucija, oblast, tipIDFK)";
    }

    @Override
    public String getInsertValues() {
        return "(" + nastavnik.getNastavnikID() + ", " + godina + ", '" + institucija + "', '" + oblast + "', " + tipUspeha.getTipUspehaID() + ")";
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
            AkademskiUspeh au = new AkademskiUspeh();
            Nastavnik n = new Nastavnik();
            n.setNastavnikID(rs.getInt("nastavnikIDPK"));
            au.setNastavnik(n);
            au.setUspehID(rs.getInt("uspehID"));
            au.setGodina(rs.getInt("godina"));
            au.setInstitucija(rs.getString("institucija"));
            au.setOblast(rs.getString("oblast"));
            au.setTipUspeha(new TipUspeha(rs.getInt("tipUspehaID"), rs.getString("nazivTipaUspeha")));
            
            vrati.add(au);
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
        return "WHERE uspehID = " + uspehID;
    }
    
}
