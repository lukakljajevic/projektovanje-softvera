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
public class ReferencaSpoljniAutor implements IDomen {
    private Referenca referenca;
    private SpoljniAutor spoljniAutor;

    public ReferencaSpoljniAutor() {
    }

    public ReferencaSpoljniAutor(Referenca referenca, SpoljniAutor spoljniAutor) {
        this.referenca = referenca;
        this.spoljniAutor = spoljniAutor;
    }

    public SpoljniAutor getSpoljniAutor() {
        return spoljniAutor;
    }

    public void setSpoljniAutor(SpoljniAutor spoljniAutor) {
        this.spoljniAutor = spoljniAutor;
    }

    public Referenca getReferenca() {
        return referenca;
    }

    public void setReferenca(Referenca referenca) {
        this.referenca = referenca;
    }

    @Override
    public String getTableName() {
        return "`referenca-spoljniautor`";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "(referencaIDP, autorIDPK)";
    }

    @Override
    public String getInsertValues() {
        return "(" + referenca.getReferencaID() + ", " + spoljniAutor.getAutorID() + ")";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOrderByColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAfterInsert(ResultSet rs) throws Exception {
        return 0;
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
    public String getWhereEqualsColumnsSingle2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
