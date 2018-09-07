/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StudijskiProgram;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabeleStudijskiProgram extends AbstractTableModel {

    private String forma = "glavnaPredmetForma";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "glavnaPredmetForma":
                try {
                    return KontrolerKlijent.getInstance().getGlavnaPredmetForma().getIzabraniPredmet().getListaStudijskihPrograma().size();
                } catch (NullPointerException e) {
                }

            case "unosPredmetaForma":
                try {
                    return KontrolerKlijent.getInstance().getUnosPredmetaForma().getPredmet().getListaStudijskihPrograma().size();
                } catch (NullPointerException e) {
                }
            case "izmenaPredmetaForma":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getPredmet().getListaStudijskihPrograma().size();
                } catch (NullPointerException e) {
                }

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
        StudijskiProgram sp = new StudijskiProgram();

        switch (forma) {
            case "glavnaPredmetForma":
                sp = KontrolerKlijent.getInstance().getGlavnaPredmetForma().getIzabraniPredmet().getListaStudijskihPrograma().get(rowIndex);
                break;
            case "unosPredmetaForma":
                sp = KontrolerKlijent.getInstance().getUnosPredmetaForma().getPredmet().getListaStudijskihPrograma().get(rowIndex);
                break;
            case "izmenaPredmetaForma":
                sp = KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getPredmet().getListaStudijskihPrograma().get(rowIndex);
                break;
            default:
                break;
        }

        switch (columnIndex) {
            case 0:
                return sp.getProgramID();
            case 1:
                return sp.getNaziv();
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
                return "Naziv studijskog programa";
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
