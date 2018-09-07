/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Luka
 */
public interface IDomen extends Serializable {
    public String getTableName();
    public String getWhereEqualsColumnsSingle();
    public String getWhereEqualsColumnsSingle2();
    public String getWhereEqualsColumnsMultiple();
    public String getWhereLikeColumnsSingle();
    public String getWhereLikeColumnsMultiple();
    public String getJoinColumnsBasic();
    public String getJoinColumnsAll();
    public String getInsertColumns();
    public String getInsertValues();
    public String getUpdateColumnsAndValues();
    public String getOrderByColumns();
    IDomen getOne(ResultSet rs) throws Exception;
    int getAfterInsert(ResultSet rs) throws Exception;
    List<IDomen> getAllBasic(ResultSet rs) throws Exception;
    List<IDomen> getAllFull(ResultSet rs) throws Exception;
    
    // Nastavnik: BASIC - TipNastavnika
    //            ALL - Referenca, 
}
