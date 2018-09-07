/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IDomen;
import domen.Korisnik;
import domen.Predaje;
import domen.Predmet;
import domen.Referenca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import konstante.Konstante;
import properties.PropertyReader;

/**
 *
 * @author Luka
 */
public class DBBroker {
    Connection connection;
    PropertyReader pr;
    
    public DBBroker() {
        pr = new PropertyReader();
    }
    
    public void ucitajDrajver() throws Exception {
        Class.forName(pr.readForKey(Konstante.DRIVER));
    }
    
    public void uspostaviKonekciju() throws Exception {
        connection = DriverManager.getConnection(pr.readForKey(Konstante.URL), pr.readForKey(Konstante.USERNAME), pr.readForKey(Konstante.PASSWORD));
        connection.setAutoCommit(false);
    }

    public void prekiniKonekciju() throws Exception {
        connection.close();
    }

    public void commit() throws Exception {
        connection.commit();
    }

    public void rollBack() throws Exception {
        connection.rollback();
    }
    
    
    
    public IDomen vratiObjekatPoViseKriterijumaJednako(IDomen domen, String[] naziviKolona, String[] vrednostiKolona) throws Exception {
        String whereUslov = "";
        for (int i = 0; i < naziviKolona.length; i++) {
            whereUslov += naziviKolona[i] + " = '" + vrednostiKolona[i] + "' AND ";
        }
        whereUslov = whereUslov.substring(0, whereUslov.length() - 4);
//        System.out.println(whereUslov);
        String query = "SELECT * FROM " + domen.getTableName() + " WHERE " + whereUslov;
//        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        IDomen vrati = domen.getOne(rs);
//        System.out.println(vrati);
        return vrati;
    }
    
    public List<IDomen> getAllJoinBasic(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsBasic()+ " " + domen.getOrderByColumns();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public List<IDomen> getAllJoinAll(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsAll();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllFull(rs);
        return vrati;
    }
    
    public List<IDomen> getAllWhereLikeColumnsSingleJoinBasic(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsBasic() + " " + domen.getWhereLikeColumnsSingle() + " " + domen.getOrderByColumns();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }

    public IDomen getOneWhereEqualsColumnsSingleJoinColumnsAll(IDomen domen) throws Exception {
        IDomen vrati;
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsAll() + " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getOne(rs);
        return vrati;
    }

    public IDomen getOneWhereEqualsColumnsSingleJoinColumnsBasic(IDomen domen) throws Exception {
        IDomen vrati;
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsBasic()+ " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getOne(rs);
        return vrati;
    }
    
    public List<IDomen> getAllWhereEqualsColumnsSingleJoinColumnsBasic(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsBasic() + " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public List<IDomen> getAllWhereEqualsColumnsSingle(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public List<IDomen> getAllWhereLikeColumnsSingle(IDomen domen) throws Exception {
        List<IDomen> vrati;
        
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getWhereLikeColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public List<IDomen> getAll(IDomen domen) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        
        String query = "SELECT * FROM " + domen.getTableName();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public int insert(IDomen domen) throws Exception {
        String query = "INSERT INTO " + domen.getTableName() + " " + domen.getInsertColumns() + " VALUES " + domen.getInsertValues();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = s.getGeneratedKeys();
        return domen.getAfterInsert(rs);
    }
    
    public List<IDomen> getAllWhereLikeColumnsSingleJoinAll(IDomen domen) throws Exception {
        List<IDomen> vrati;
        
        String query = "SELECT * FROM " + domen.getTableName() + " " + domen.getJoinColumnsAll() + " " + domen.getWhereLikeColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        vrati = domen.getAllBasic(rs);
        return vrati;
    }
    
    public void deleteWhereEqualsColumnSingle(IDomen domen) throws Exception {
        String query = "DELETE FROM " + domen.getTableName() + " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }
    
    public void deleteWhereEqualsColumnSingle2(IDomen domen) throws Exception {
        String query = "DELETE FROM " + domen.getTableName() + " " + domen.getWhereEqualsColumnsSingle2();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }

    public void deleteWhereEqualsColumnMultiple(IDomen domen) throws Exception {
        String query = "DELETE FROM " + domen.getTableName() + " " + domen.getWhereEqualsColumnsMultiple();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }
    
    public void updateWhereEqualsColumnSingle(IDomen domen) throws Exception {
        String query = "UPDATE " + domen.getTableName() + " SET " + domen.getUpdateColumnsAndValues() + " " + domen.getWhereEqualsColumnsSingle();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }
    
    public void updateWhereEqualsColumnMultiple(IDomen domen) throws Exception {
        String query = "UPDATE " + domen.getTableName() + " SET " + domen.getUpdateColumnsAndValues() + " " + domen.getWhereEqualsColumnsMultiple();
        System.out.println(query);
        Statement s = connection.createStatement();
        s.executeUpdate(query);
    }
}
