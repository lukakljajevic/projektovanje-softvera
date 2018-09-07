/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Nastavnik;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Luka
 */
public class ModelTabelePretragaNastavnik extends AbstractTableModel {

    private String forma = "glavnaKlijentForma";

    @Override
    public int getRowCount() {
        switch (forma) {
            case "glavnaKlijentForma":
                return KontrolerKlijent.getInstance().getListaNastavnikaPretraga().size();
            case "glavnaPredmetForma":
                try {
                    return KontrolerKlijent.getInstance().getGlavnaPredmetForma().getIzabraniPredmet().getListaPredavanja().size();
                } catch (NullPointerException e) {
                }

            case "unosPredmetaForma":
                try {
                    return KontrolerKlijent.getInstance().getUnosPredmetaForma().getListaNastavnikaPretraga().size();
                } catch (NullPointerException e) {
                }
            case "unosReferenceFormaPretraga":
                try {
                    return KontrolerKlijent.getInstance().getUnosReferenceForma().getListaNastavnikaPretraga().size();
                } catch (NullPointerException e) {
                }
            case "unosReferenceFormaReferenca":
                try {
                    return KontrolerKlijent.getInstance().getUnosReferenceForma().getReferenca().getListaNastavnika().size();
                } catch (NullPointerException e) {
                }
            case "izmenaPredmetaForma":
                try {
                    return KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getListaNastavnikaPretraga().size();
                } catch (NullPointerException e) {
                }
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
        Nastavnik n = new Nastavnik();
        switch (forma) {
            case "glavnaKlijentForma":
                n = KontrolerKlijent.getInstance().getListaNastavnikaPretraga().get(rowIndex);
                break;
            case "glavnaPredmetForma":
                n = KontrolerKlijent.getInstance().getGlavnaPredmetForma().getIzabraniPredmet().getListaPredavanja().get(rowIndex).getNastavnik();
                break;
            case "unosPredmetaForma":
                n = KontrolerKlijent.getInstance().getUnosPredmetaForma().getListaNastavnikaPretraga().get(rowIndex);
                break;
            case "unosReferenceFormaPretraga":
                n = KontrolerKlijent.getInstance().getUnosReferenceForma().getListaNastavnikaPretraga().get(rowIndex);
                break;
            case "unosReferenceFormaReferenca":
                n = KontrolerKlijent.getInstance().getUnosReferenceForma().getReferenca().getListaNastavnika().get(rowIndex);
                break;
            case "izmenaPredmetaForma":
                n = KontrolerKlijent.getInstance().getIzmenaPredmetaForma().getListaNastavnikaPretraga().get(rowIndex);
                break;
            default:
                break;
        }

        switch (columnIndex) {
            case 0:
                return n.getNastavnikID();
            case 1:
                return n.getImePrezime();
            case 2:
                return n.getTipNastavnika().getNaziv();
            case 3:
                return n.getNaucnaOblast();
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
            case 2:
                return "Tip nastavnika";
            case 3:
                return "Naucna oblast";
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
