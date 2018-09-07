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
public class PredmetStudijskiProgram implements IDomen {
    private Predmet predmet;
    private StudijskiProgram studijskiProgram;

    public PredmetStudijskiProgram() {
    }

    public PredmetStudijskiProgram(Predmet predmet, StudijskiProgram studijskiProgram) {
        this.predmet = predmet;
        this.studijskiProgram = studijskiProgram;
    }

    public StudijskiProgram getStudijskiProgram() {
        return studijskiProgram;
    }

    public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
        this.studijskiProgram = studijskiProgram;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    @Override
    public String getTableName() {
        return "`predmet-studijskiprogram`";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE predmetIDPK = " + predmet.getPredmetID();
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        return "WHERE predmetIDPK = " + predmet.getPredmetID() + " AND programIDPK = " + studijskiProgram.getProgramID();
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
        return "(predmetIDPK, programIDPK)";
    }

    @Override
    public String getInsertValues() {
        return "(" + predmet.getPredmetID() + ", " + studijskiProgram.getProgramID() + ")";
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
    public String getOrderByColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereEqualsColumnsSingle2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
