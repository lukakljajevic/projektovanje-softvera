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
public class Nastavnik implements IDomen {

    private int nastavnikID;
    private String imePrezime;
    private String institucija;
    private String naucnaOblast;
    private TipNastavnika tipNastavnika;
    private List<AkademskiUspeh> listaAkademskihUspeha;
    private List<Usavrsavanje> listaUsavrsavanja;
    private List<Predaje> listaPredavanja;
    private List<Referenca> listaReferenci;

    public Nastavnik() {
        listaAkademskihUspeha = new ArrayList<>();
        listaUsavrsavanja = new ArrayList<>();
        listaPredavanja = new ArrayList<>();
        listaReferenci = new ArrayList<>();
    }

    public Nastavnik(int nastavnikID, String imePrezime, String institucija, String naucnaOblast, TipNastavnika tipNastavnika, List<AkademskiUspeh> listaAkademskihUspeha, List<Usavrsavanje> listaUsavrsavanja, List<Predaje> listaPredavanja, List<Referenca> listaReferenci) {
        this.nastavnikID = nastavnikID;
        this.imePrezime = imePrezime;
        this.institucija = institucija;
        this.naucnaOblast = naucnaOblast;
        this.tipNastavnika = tipNastavnika;
        this.listaAkademskihUspeha = listaAkademskihUspeha;
        this.listaUsavrsavanja = listaUsavrsavanja;
        this.listaPredavanja = listaPredavanja;
        this.listaReferenci = listaReferenci;
    }

    public List<Referenca> getListaReferenci() {
        return listaReferenci;
    }

    public void setListaReferenci(List<Referenca> listaReferenci) {
        this.listaReferenci = listaReferenci;
    }

    public List<Predaje> getListaPredavanja() {
        return listaPredavanja;
    }

    public void setListaPredavanja(List<Predaje> listaPredavanja) {
        this.listaPredavanja = listaPredavanja;
    }

    public int getNastavnikID() {
        return nastavnikID;
    }

    public void setNastavnikID(int nastavnikID) {
        this.nastavnikID = nastavnikID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getInstitucija() {
        return institucija;
    }

    public void setInstitucija(String institucija) {
        this.institucija = institucija;
    }

    public String getNaucnaOblast() {
        return naucnaOblast;
    }

    public void setNaucnaOblast(String naucnaOblast) {
        this.naucnaOblast = naucnaOblast;
    }

    public TipNastavnika getTipNastavnika() {
        return tipNastavnika;
    }

    public void setTipNastavnika(TipNastavnika tipNastavnika) {
        this.tipNastavnika = tipNastavnika;
    }

    public List<AkademskiUspeh> getListaAkademskihUspeha() {
        return listaAkademskihUspeha;
    }

    public void setListaAkademskihUspeha(List<AkademskiUspeh> listaAkademskihUspeha) {
        this.listaAkademskihUspeha = listaAkademskihUspeha;
    }

    public List<Usavrsavanje> getListaUsavrsavanja() {
        return listaUsavrsavanja;
    }

    public void setListaUsavrsavanja(List<Usavrsavanje> listaUsavrsavanja) {
        this.listaUsavrsavanja = listaUsavrsavanja;
    }

    @Override
    public String getTableName() {
        return "nastavnik";
    }

    @Override
    public String getJoinColumnsBasic() {
        return "JOIN `tip-nastavnika` ON tipNastavnikaFK = tipNastavnikaID";
    }

    @Override
    public String getJoinColumnsAll() {
        return "LEFT JOIN `tip-nastavnika` ON tipNastavnikaFK = tipNastavnikaID \n"
                + "LEFT JOIN `predaje` ON nastavnikIDPredaje = nastavnikID \n"
                + "LEFT JOIN `predmet` ON predmetIDPredaje = predmetID \n"
                + "LEFT JOIN `predmet-studijskiprogram` ON predmetIDPK = predmetID \n"
                + "LEFT JOIN `studijski-program` ON programID = programIDPK \n"
                + "LEFT JOIN `referenca-nastavnik` ON nastavnikIDPK = nastavnikID \n"
                + "LEFT JOIN `referenca` ON referencaIDPK = referencaID \n"
                + "LEFT JOIN `referenca-spoljniautor` ON referencaID = referencaIDP\n"
                + "LEFT JOIN `spoljni-autor` ON autorID = autorIDPK";
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        Nastavnik vrati = new Nastavnik();
        int brojac = 0;
        while (rs.next()) {
            brojac++;
            if (brojac == 1) {
                vrati.setNastavnikID(rs.getInt("nastavnikID"));
                vrati.setImePrezime(rs.getString("imePrezime"));
                vrati.setInstitucija(rs.getString("institucija"));
                vrati.setNaucnaOblast(rs.getString("naucnaOblast"));
                vrati.setTipNastavnika(new TipNastavnika(rs.getInt("tipNastavnikaID"), rs.getString("nazivTipaNastavnika")));
            }

            int predmetID = rs.getInt("predmetID");
            if (predmetID > 0) {
                Predmet p = new Predmet();
                p.setPredmetID(predmetID);
                p.setNaziv(rs.getString("naziv"));

                if (!sadrziPredmet(vrati, predmetID)) {
                    vrati.getListaPredavanja().add(new Predaje(null, p, rs.getInt("brojCasova")));
                }

                int programID = rs.getInt("programID");

                if (!sadrziProgram(vrati, predmetID, programID)) {
                    String nazivPrograma = rs.getString("nazivPrograma");
                    dodajProgram(vrati, predmetID, programID, nazivPrograma);
                }
            }

            int referencaID = rs.getInt("referencaID");
            if (referencaID > 0) {
                Referenca r = new Referenca();
                r.setReferencaID(referencaID);
                r.setGodina(rs.getInt("godina"));
                r.setNaslov(rs.getString("naslov"));

                if (!sadrziReferencu(vrati, referencaID)) {
                    vrati.getListaReferenci().add(r);
                }

                int autorID = rs.getInt("autorID");
                if (autorID > 0) {
                    String nazivAutora = rs.getString("imePrezimeAutora");
                    SpoljniAutor sa = new SpoljniAutor(autorID, nazivAutora);
                    if (!sadrziAutora(vrati, referencaID, sa)) {
                        dodajAutoraUReferencu(vrati, referencaID, sa);
                    }
                }
            }

        }
        return vrati;
    }

    @Override
    public List<IDomen> getAllBasic(ResultSet rs) throws Exception {
        List<IDomen> vrati = new ArrayList<>();

        while (rs.next()) {
            Nastavnik n = new Nastavnik();
            n.setNastavnikID(rs.getInt("nastavnikID"));
            n.setImePrezime(rs.getString("imePrezime"));
            n.setNaucnaOblast(rs.getString("naucnaOblast"));
            n.setTipNastavnika(new TipNastavnika(rs.getInt("tipNastavnikaFK"), rs.getString("nazivTipaNastavnika")));
            n.setNaucnaOblast(rs.getString("naucnaOblast"));
            vrati.add(n);
        }
        rs.close();
        return vrati;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE nastavnikID = " + nastavnikID;
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereLikeColumnsSingle() {
        return "WHERE imePrezime LIKE '%" + imePrezime + "%'";
    }

    @Override
    public String getWhereLikeColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertColumns() {
        return "(imePrezime, institucija, naucnaOblast, tipNastavnikaFK)";
    }

    @Override
    public String getInsertValues() {
        return "('" + imePrezime + "', '" + institucija + "', '" + naucnaOblast + "', " + tipNastavnika.getTipNastavnikaID() + ")";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        return "imePrezime = '" + imePrezime + "', institucija = '" + institucija + "', naucnaOblast = '" + naucnaOblast + "', tipNastavnikaFK = " + tipNastavnika.getTipNastavnikaID();
    }

    @Override
    public List<IDomen> getAllFull(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean sadrziPredmet(Nastavnik vrati, int predmetID) {
        for (Predaje predaje : vrati.getListaPredavanja()) {
            if (predaje.getPredmet().getPredmetID() == predmetID) {
                return true;
            }
        }
        return false;
    }

    private boolean sadrziProgram(Nastavnik vrati, int predmetID, int programID) {
        for (Predaje predaje : vrati.getListaPredavanja()) {
            if (predaje.getPredmet().getPredmetID() == predmetID) {
                for (StudijskiProgram program : predaje.getPredmet().getListaStudijskihPrograma()) {
                    if (program.getProgramID() == programID) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dodajProgram(Nastavnik vrati, int predmetID, int programID, String nazivPrograma) {
        for (Predaje predaje : vrati.getListaPredavanja()) {
            if (predaje.getPredmet().getPredmetID() == predmetID) {
                StudijskiProgram program = new StudijskiProgram();
                program.setProgramID(programID);
                program.setNaziv(nazivPrograma);
                predaje.getPredmet().getListaStudijskihPrograma().add(program);
            }
        }
    }

    private boolean sadrziReferencu(Nastavnik vrati, int referencaID) {
        for (Referenca r : vrati.getListaReferenci()) {
            if (r.getReferencaID() == referencaID) {
                return true;
            }
        }
        return false;
    }

    private boolean sadrziAutora(Nastavnik vrati, int referencaID, SpoljniAutor sa) {
        for (Referenca r : vrati.getListaReferenci()) {
            if (r.getReferencaID() == referencaID) {
                for (SpoljniAutor sai : r.getListaSpoljnihAutora()) {
                    if (sai.getAutorID() == sa.getAutorID()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dodajAutoraUReferencu(Nastavnik vrati, int referencaID, SpoljniAutor sa) {
        for (Referenca r : vrati.getListaReferenci()) {
            if (r.getReferencaID() == referencaID) {
                r.getListaSpoljnihAutora().add(sa);
            }
        }
    }

    @Override
    public int getAfterInsert(ResultSet rs) throws Exception {
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    @Override
    public String getOrderByColumns() {
        return "";
    }

    @Override
    public String getWhereEqualsColumnsSingle2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
