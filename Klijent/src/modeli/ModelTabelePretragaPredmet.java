/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Predmet;
import domen.StudijskiProgram;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabelePretragaPredmet extends AbstractTableModel {
    
    private String forma = "";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "unosNastavnikaForma":
                return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getListaPredmetaPretraga().size();
            case "izmenaNastavnikaForma":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getListaPredmetaPretraga().size();
                } catch (NullPointerException e) {}
                return 0;
                
            default:
                return KontrolerKlijent.getInstance().getListaPredmetaPretraga().size();
        }
        
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predmet predmet;
        
        switch (forma) {
            case "unosNastavnikaForma":
                predmet = KontrolerKlijent.getInstance().getUnosNastavnikaForma().getListaPredmetaPretraga().get(rowIndex);
                break;
            case "izmenaNastavnikaForma":
                predmet = KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getListaPredmetaPretraga().get(rowIndex);
                break;
            default:
                predmet =  KontrolerKlijent.getInstance().getListaPredmetaPretraga().get(rowIndex);
                break;
        }
        
        switch (columnIndex) {
            case 0:
                return predmet.getPredmetID();
            case 1:
                return predmet.getNaziv();
            case 2:
                return predmet.getNazivStudijskihPrograma();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Naziv predmeta";
            case 2:
                return "Studijski programi";
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
