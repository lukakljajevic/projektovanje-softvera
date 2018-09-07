/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luka
 */
public class Predmet implements IDomen {

    private int predmetID;
    private String naziv;
    private List<StudijskiProgram> listaStudijskihPrograma;
    private List<Predaje> listaPredavanja;

    public Predmet() {
        listaPredavanja = new ArrayList<>();
        listaStudijskihPrograma = new ArrayList<>();
    }

    public Predmet(int predmetID, String naziv, List<StudijskiProgram> listaStudijskihPrograma, List<Predaje> listaPredavanja) {
        this.predmetID = predmetID;
        this.naziv = naziv;
        this.listaStudijskihPrograma = listaStudijskihPrograma;
        this.listaPredavanja = listaPredavanja;
    }

    public List<Predaje> getListaPredavanja() {
        return listaPredavanja;
    }

    public void setListaPredavanja(List<Predaje> listaPredavanja) {
        this.listaPredavanja = listaPredavanja;
    }

    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<StudijskiProgram> getListaStudijskihPrograma() {
        return listaStudijskihPrograma;
    }

    public void setListaStudijskihPrograma(List<StudijskiProgram> listaStudijskihPrograma) {
        this.listaStudijskihPrograma = listaStudijskihPrograma;
    }

    @Override
    public String getTableName() {
        return "predmet";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE predmetID = " + predmetID;
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereLikeColumnsSingle() {
        return "WHERE naziv LIKE '%" + naziv + "%'";
    }

    @Override
    public String getWhereLikeColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinColumnsBasic() {
        return "JOIN `predmet-studijskiprogram` ON predmetID = predmetIDPK JOIN `studijski-program` ON programIDPK = programID";
    }

    @Override
    public String getJoinColumnsAll() {
        return "JOIN `predmet-studijskiprogram` ON predmetID = predmetIDPK JOIN `studijski-program` ON programIDPK = programID LEFT JOIN `predaje` ON predmetIDPredaje = predmetID LEFT JOIN `nastavnik` ON nastavnikIDPredaje = nastavnikID LEFT JOIN `tip-nastavnika` ON tipNastavnikaFK = tipNastavnikaID";
    }

    @Override
    public String getInsertColumns() {
        return "(naziv)";
    }

    @Override
    public String getInsertValues() {
        return "('" + naziv + "')";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        return "naziv = '" + naziv + "'";
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        Predmet vrati = new Predmet();
        while (rs.next()) {
            vrati.setPredmetID(rs.getInt("predmetID"));
            vrati.setNaziv(rs.getString("naziv"));

            StudijskiProgram program = new StudijskiProgram();
            program.setProgramID(rs.getInt("programID"));
            program.setNaziv(rs.getString("nazivPrograma"));

            if (!sadrziProgram(vrati, program.getProgramID())) {
                vrati.getListaStudijskihPrograma().add(program);
            }

            int nastavnikID = rs.getInt("nastavnikID");
            if (nastavnikID > 0) {
                Nastavnik n = new Nastavnik();
                n.setNastavnikID(nastavnikID);
                n.setImePrezime(rs.getString("imePrezime"));
                n.setNaucnaOblast(rs.getString("naucnaOblast"));
                n.setTipNastavnika(new TipNastavnika(rs.getInt("tipNastavnikaFK"), rs.getString("nazivTipaNastavnika")));

                Predaje p = new Predaje(n, null, rs.getInt("brojCasova"));
                if (!sadrziNastavnika(vrati, n.getNastavnikID())) {
                    vrati.getListaPredavanja().add(p);
                }
            }

        }
        return vrati;
    }

    @Override
    public List<IDomen> getAllBasic(ResultSet rs) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        Predmet predmet = new Predmet();
        int brojac = 0;
        while (rs.next()) {

            predmet.setPredmetID(rs.getInt("predmetID"));
            predmet.setNaziv(rs.getString("naziv"));

            StudijskiProgram sp = new StudijskiProgram();
            sp.setProgramID(rs.getInt("programID"));
            sp.setNaziv(rs.getString("nazivPrograma"));
            predmet.getListaStudijskihPrograma().add(sp);

            if (rs.next()) {
                Predmet sledeciPredmet = new Predmet();
                sledeciPredmet.setPredmetID(rs.getInt("predmetID"));
                sledeciPredmet.setNaziv(rs.getString("naziv"));

                if (predmet.getPredmetID() != sledeciPredmet.getPredmetID()) {
                    vrati.add(predmet);
                    predmet = new Predmet();
                }
                rs.previous();
            } else {
                vrati.add(predmet);
            }

        }
        rs.close();
        return vrati;
    }

    public Object getNazivStudijskihPrograma() {
        String ispis = "";
        for (StudijskiProgram sp : listaStudijskihPrograma) {
            ispis += sp.getNaziv() + ", ";
        }
        if (ispis != "") {
            ispis = ispis.substring(0, ispis.length() - 2);
        }

        return ispis;
    }

    @Override
    public List<IDomen> getAllFull(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean sadrziProgram(Predmet p, int pID) {
        for (StudijskiProgram studijskiProgram : p.getListaStudijskihPrograma()) {
            if (studijskiProgram.getProgramID() == pID) {
                return true;
            }
        }
        return false;
    }

    private boolean sadrziNastavnika(Predmet p, int nID) {
        for (Predaje predaje : p.getListaPredavanja()) {
            if (predaje.getNastavnik().getNastavnikID() == nID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getAfterInsert(ResultSet rs) throws Exception {
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    private boolean sadrziPredmet(List<Predmet> vrati, Predmet predmet) {
        for (Predmet p : vrati) {
            if (p.getPredmetID() == predmet.getPredmetID()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getOrderByColumns() {
        return "ORDER BY predmetID";
    }

    @Override
    public String getWhereEqualsColumnsSingle2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
