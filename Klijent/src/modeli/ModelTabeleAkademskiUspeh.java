/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.AkademskiUspeh;
import domen.Nastavnik;
import forme.UnosNovogNastavnikaForma;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabeleAkademskiUspeh extends AbstractTableModel {

    private String forma = "";

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public int getRowCount() {
        switch (forma) {
            case "unosNastavnikaForma":
                try {
                    return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaAkademskihUspeha().size();
                } catch (NullPointerException e) {
                }
                return 0;
            case "izmenaNastavnikaForma":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaAkademskihUspeha().size();
                } catch (NullPointerException e) {
                }
                return 0;
            default:
                try {
                    return KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaAkademskihUspeha().size();
                } catch (NullPointerException e) {
                }
                return 0;
        }

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AkademskiUspeh uspeh;

        switch (forma) {
            case "unosNastavnikaForma":
                uspeh = KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaAkademskihUspeha().get(rowIndex);
                break;
            case "izmenaNastavnikaForma":
                uspeh = KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaAkademskihUspeha().get(rowIndex);
                break;
            default:
                uspeh = KontrolerKlijent.getInstance().getGlavnaNastavnikForma().getNastavnik().getListaAkademskihUspeha().get(rowIndex);
                break;
        }

        switch (columnIndex) {
            case 0:
                return uspeh.getTipUspeha().getNaziv();
            case 1:
                return uspeh.getGodina();
            case 2:
                return uspeh.getInstitucija();
            case 3:
                return uspeh.getOblast();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Tip uspeha";
            case 1:
                return "Godina";
            case 2:
                return "Institucija";
            case 3:
                return "Oblast";
            default:
                return "";
        }
    }

}
