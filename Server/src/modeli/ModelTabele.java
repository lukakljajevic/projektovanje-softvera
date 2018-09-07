/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Korisnik;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerServer;

/**
 *
 * @author Luka
 */
public class ModelTabele extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return KontrolerServer.getInstance().getListaUlogovanihKorisnika().size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = KontrolerServer.getInstance().getListaUlogovanihKorisnika().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKorisnikID();

            case 1:
                return k.getUsername();

            case 2:
                return k.getIme();

            case 3:
                return k.getPrezime();

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
                return "Username";

            case 2:
                return "Ime";

            case 3:
                return "Prezime";

            default:
                return "";

        }
    }
    
    
    
}
