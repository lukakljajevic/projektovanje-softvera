/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.SpoljniAutor;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabeleSpoljniAutor extends AbstractTableModel {

    private String forma = "";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "unosReferenceFormaPretraga":
                return KontrolerKlijent.getInstance().getUnosReferenceForma().getListaAutoraPretraga().size();
            case "unosReferenceFormaReferenca":
                return KontrolerKlijent.getInstance().getUnosReferenceForma().getReferenca().getListaSpoljnihAutora().size();
            default:
                return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SpoljniAutor sa = new SpoljniAutor();
        switch (forma) {
            case "unosReferenceFormaPretraga":
                sa = KontrolerKlijent.getInstance().getUnosReferenceForma().getListaAutoraPretraga().get(rowIndex);
                break;
            case "unosReferenceFormaReferenca":
                sa = KontrolerKlijent.getInstance().getUnosReferenceForma().getReferenca().getListaSpoljnihAutora().get(rowIndex);
                break;
            default:
                break;
        }

        switch (columnIndex) {
            case 0:
                return sa.getAutorID();
            case 1:
                return sa.getImePrezime();
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
                return "Ime i prezime";
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
