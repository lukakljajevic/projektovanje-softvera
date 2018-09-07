/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Nastavnik;
import domen.Usavrsavanje;
import forme.UnosNovogNastavnikaForma;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabeleUsavrsavanja extends AbstractTableModel {

    private String forma = "glavnaNastavnikForma";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "unosNastavnikaForma":
                try {
                    return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaUsavrsavanja().size();
                } catch (NullPointerException e) {
                }
            case "izmenaNastavnikaForma":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaUsavrsavanja().size();
                } catch (NullPointerException e) {
                }
            default:
                try {
                    return KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaUsavrsavanja().size();
                } catch (NullPointerException e) {
                }
                return 0;
        }

    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usavrsavanje usavrsavanje = new Usavrsavanje();;

        switch (forma) {
            case "izmenaNastavnikaForma":
                usavrsavanje = KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaUsavrsavanja().get(rowIndex);
                break;
            case "unosNastavnikaForma":
                usavrsavanje = KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaUsavrsavanja().get(rowIndex);
                break;
            default:
                usavrsavanje = KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaUsavrsavanja().get(rowIndex);
                break;
        }

        switch (columnIndex) {
            case 0:
                return usavrsavanje.getNaziv();
            case 1:
                return usavrsavanje.getInstitucija();
            case 2:
                return usavrsavanje.getGodina();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Naziv";
            case 1:
                return "Institucija";
            case 2:
                return "Godina";
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
