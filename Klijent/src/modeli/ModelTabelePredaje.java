/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Predaje;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabelePredaje extends AbstractTableModel {

    private String forma = "unosNastavnikaForma";

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
                return KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaPredavanja().size();
            case "unosPredmetaForma":
                try {
                    return KontrolerKlijent.getInstance().getUnosPredmetaForma().getPredmet().getListaPredavanja().size();
                } catch (NullPointerException e) {}
                return 0;
            case "izmenaPredmetaForma":
                return KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getPredmet().getListaPredavanja().size();
            case "izmenaNastavnikaForma":
                return KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaPredavanja().size();
            default:
                return 0;
        }

    }

    @Override
    public int getColumnCount() {
        return 4;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Predaje predaje = new Predaje();

        switch (forma) {
            case "unosNastavnikaForma":
                predaje = KontrolerKlijent.getInstance().getUnosNastavnikaForma().getNastavnik().getListaPredavanja().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return predaje.getPredmet().getPredmetID();
                    case 1:
                        return predaje.getPredmet().getNaziv();
                    case 2:
                        return predaje.getPredmet().getNazivStudijskihPrograma();
                    case 3:
                        return predaje.getBrojCasova();
                    default:
                        return "";
                }
            case "unosPredmetaForma":
                predaje = KontrolerKlijent.getInstance().getUnosPredmetaForma().getPredmet().getListaPredavanja().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return predaje.getNastavnik().getNastavnikID();
                    case 1:
                        return predaje.getNastavnik().getImePrezime();
                    case 2:
                        return predaje.getNastavnik().getTipNastavnika().getNaziv();
                    case 3:
                        return predaje.getBrojCasova();
                    default:
                        return "";
                }
            case "izmenaPredmetaForma":
                predaje = KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getPredmet().getListaPredavanja().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return predaje.getNastavnik().getNastavnikID();
                    case 1:
                        return predaje.getNastavnik().getImePrezime();
                    case 2:
                        return predaje.getNastavnik().getTipNastavnika().getNaziv();
                    case 3:
                        return predaje.getBrojCasova();
                    default:
                        return "";
                }
            case "izmenaNastavnikaForma":
                predaje = KontrolerKlijent.getInstance().getIzmenaNastavnikaForma().getNastavnik().getListaPredavanja().get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return predaje.getPredmet().getPredmetID();
                    case 1:
                        return predaje.getPredmet().getNaziv();
                    case 2:
                        return predaje.getPredmet().getNazivStudijskihPrograma();
                    case 3:
                        return predaje.getBrojCasova();
                    default:
                        return "";
                }
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {

        switch (forma) {
            case "unosNastavnikaForma":
                switch (column) {
                    case 0:
                        return "ID";
                    case 1:
                        return "Naziv";
                    case 2:
                        return "Programi";
                    case 3:
                        return "Broj casova";
                    default:
                        return "";
                }

            case "unosPredmetaForma":
                switch (column) {
                    case 0:
                        return "ID";
                    case 1:
                        return "Ime i prezime";
                    case 2:
                        return "Tip nastavnika";
                    case 3:
                        return "Broj casova";
                    default:
                        return "";
                }
            case "izmenaPredmetaForma":
                switch (column) {
                    case 0:
                        return "ID";
                    case 1:
                        return "Ime i prezime";
                    case 2:
                        return "Tip nastavnika";
                    case 3:
                        return "Broj casova";
                    default:
                        return "";
                }
            case "izmenaNastavnikaForma":
                switch (column) {
                    case 0:
                        return "ID";
                    case 1:
                        return "Naziv";
                    case 2:
                        return "Programi";
                    case 3:
                        return "Broj casova";
                    default:
                        return "";
                }
            default:
                return "";
        }

    }

}
