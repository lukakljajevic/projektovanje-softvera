/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Predaje;
import domen.Predmet;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabelePredmetiNastavnika extends AbstractTableModel {

    @Override
    public int getRowCount() {
        try {
            return KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaPredavanja().size();
        } catch (NullPointerException e) {}
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predaje predaje = KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaPredavanja().get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return predaje.getPredmet().getNaziv();
            case 1:
                return predaje.getPredmet().getNazivStudijskihPrograma();
            case 2:
                return predaje.getBrojCasova();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Naziv predmeta";
            case 1:
                return "Studijski programi";
            case 2:
                return "Broj casova";
            default:
                return "";
        }
    }
    
    
    
}
