/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Referenca;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabeleReference extends AbstractTableModel {
    
    private String forma = "";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "unosNastavnikaFormaPretraga":
                try {
                    return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getListaReferenciPretraga().size();
                } catch (NullPointerException e) {}
                return 0;
            case "unosNastavnikaFormaNastavnik":
                try {
                    return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaReferenci().size();
                } catch (NullPointerException e) {}
                return 0;
            case "izmenaNastavnikaFormaPretraga":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getListaReferenciPretraga().size();
                } catch (NullPointerException e) {}
                return 0;
            case "izmenaNastavnikaFormaNastavnik":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaReferenci().size();
                } catch (NullPointerException e) {}
                return 0;
            default:
                try {
                    return KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaReferenci().size();
                } catch (NullPointerException e) {}
                return 0;
                
        }
        
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Referenca referenca;
        
        switch (forma) {
            case "unosNastavnikaFormaPretraga":
                referenca =  KontrolerKlijent.getInstance().getUnosNastavnikaForma().getListaReferenciPretraga().get(rowIndex);
                break;
            case "unosNastavnikaFormaNastavnik":
                referenca =  KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaReferenci().get(rowIndex);
                break;
            case "izmenaNastavnikaFormaPretraga":
                referenca =  KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getListaReferenciPretraga().get(rowIndex);
                break;
            case "izmenaNastavnikaFormaNastavnik":
                referenca =  KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaReferenci().get(rowIndex);
                break;
            default:
                referenca =  KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaReferenci().get(rowIndex);
                break;
        }
        
        switch (columnIndex) {
            case 0:
                return referenca.getNaslov();
            case 1:
                return referenca.getGodina();
            case 2:
                return referenca.vratiAutore();
            case 3:
                return referenca.vratiNastavnike();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Naslov";
            case 1:
                return "Godina";
            case 2:
                return "Autori";
            case 3:
                return "Nastavnici";
            default:
                return "";
        }
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    
    
    
    
    
}
