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
public class Referenca implements IDomen {

    private int referencaID;
    private String naslov;
    private int godina;
    private List<Nastavnik> listaNastavnika;
    private List<SpoljniAutor> listaSpoljnihAutora;

    public Referenca() {
        listaNastavnika = new ArrayList<>();
        listaSpoljnihAutora = new ArrayList<>();
    }

    public Referenca(int referencaID, String naziv, int godina, List<Nastavnik> listaNastavnika, List<SpoljniAutor> listaSpoljnihAutora) {
        this.referencaID = referencaID;
        this.naslov = naziv;
        this.godina = godina;
        this.listaNastavnika = listaNastavnika;
        this.listaSpoljnihAutora = listaSpoljnihAutora;
    }

    public int getReferencaID() {
        return referencaID;
    }

    public void setReferencaID(int referencaID) {
        this.referencaID = referencaID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public List<Nastavnik> getListaNastavnika() {
        return listaNastavnika;
    }

    public void setListaNastavnika(List<Nastavnik> listaNastavnika) {
        this.listaNastavnika = listaNastavnika;
    }

    public List<SpoljniAutor> getListaSpoljnihAutora() {
        return listaSpoljnihAutora;
    }

    public void setListaSpoljnihAutora(List<SpoljniAutor> listaSpoljnihAutora) {
        this.listaSpoljnihAutora = listaSpoljnihAutora;
    }

    @Override
    public String getTableName() {
        return "referenca";
    }

    @Override
    public String getWhereEqualsColumnsSingle() {
        return "WHERE referencaID = " + referencaID;
    }

    @Override
    public String getWhereEqualsColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereLikeColumnsSingle() {
        return "WHERE naslov LIKE '%" + naslov + "%'";
    }

    @Override
    public String getWhereLikeColumnsMultiple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinColumnsBasic() {
        return "JOIN `referenca-nastavnik` ON referencaID = referencaIDPK JOIN `nastavnik` ON nastavnikIDPK = nastavnikID";
    }

    @Override
    public String getJoinColumnsAll() {
        return "LEFT JOIN `referenca-nastavnik` ON referencaID = referencaIDPK LEFT JOIN `nastavnik` ON nastavnikIDPK = nastavnikID LEFT JOIN `referenca-spoljniautor` ON referencaID = referencaIDP LEFT JOIN `spoljni-autor` ON autorIDPK = autorID";
    }

    @Override
    public String getInsertColumns() {
        return "(naslov, godina)";
    }

    @Override
    public String getInsertValues() {
        return "('" + naslov + "', " + godina + ")";
    }

    @Override
    public String getUpdateColumnsAndValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IDomen getOne(ResultSet rs) throws Exception {
        Referenca vrati = new Referenca();
        int brojac = 0;
        while (rs.next()) {
            brojac++;
            if (brojac == 1) {
                vrati.setReferencaID(rs.getInt("referencaID"));
            }

            Nastavnik n = new Nastavnik();

            n.setNastavnikID(rs.getInt("nastavnikID"));
            n.setImePrezime(rs.getString("imePrezime"));

            vrati.getListaNastavnika().add(n);
        }

        return vrati;
    }

    @Override
    public List<IDomen> getAllBasic(ResultSet rs) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        Referenca r = new Referenca();
        while (rs.next()) {

            r.setReferencaID(rs.getInt("referencaID"));
            r.setNaslov(rs.getString("naslov"));
            r.setGodina(rs.getInt("godina"));

            int nastavnikID = rs.getInt("nastavnikID");
            if (nastavnikID > 0) {
                Nastavnik n = new Nastavnik();
                n.setNastavnikID(nastavnikID);
                n.setImePrezime(rs.getString("imePrezime"));
                n.setInstitucija(rs.getString("institucija"));
                n.setNaucnaOblast(rs.getString("naucnaOblast"));
                if (!sadrziNastavnika(r, n)) {

                    r.getListaNastavnika().add(n);
                }
            }

            int autorID = rs.getInt("autorID");
            if (autorID > 0) {
                SpoljniAutor sa = new SpoljniAutor();
                sa.setAutorID(rs.getInt("autorID"));
                sa.setImePrezime(rs.getString("imePrezimeAutora"));
                if (!sadrziAutora(r, sa)) {

                    r.getListaSpoljnihAutora().add(sa);
                }
            }

            if (rs.next()) {
                Referenca sledecaReferenca = new Referenca();
                sledecaReferenca.setReferencaID(rs.getInt("referencaID"));
                sledecaReferenca.setNaslov(rs.getString("naslov"));
                sledecaReferenca.setGodina(rs.getInt("godina"));

                if (sledecaReferenca.getReferencaID() != r.getReferencaID()) {
                    vrati.add(r);
                    r = new Referenca();
                }
                rs.previous();
            } else {
                vrati.add(r);
            }

        }

        rs.close();
        return vrati;
    }

    @Override
    public List<IDomen> getAllFull(ResultSet rs) throws Exception {
        List<IDomen> vrati = new ArrayList<>();
        Referenca r = new Referenca();
        while (rs.next()) {

            r.setReferencaID(rs.getInt("referencaID"));
            r.setNaslov(rs.getString("naslov"));
            r.setGodina(rs.getInt("godina"));

            int nastavnikID = rs.getInt("nastavnikID");
            if (nastavnikID > 0) {
                Nastavnik n = new Nastavnik();
                n.setNastavnikID(nastavnikID);
                n.setImePrezime(rs.getString("imePrezime"));
                if (!sadrziNastavnika(r, n)) {
                    r.getListaNastavnika().add(n);
                }
            }

            int autorID = rs.getInt("autorID");
            if (autorID > 0) {
                SpoljniAutor sa = new SpoljniAutor(autorID, rs.getString("imePrezimeAutora"));
                if (!sadrziAutora(r, sa)) {
                    r.getListaSpoljnihAutora().add(sa);
                }
            }

            if (rs.next()) {
                int referencaIDSledeca = rs.getInt("referencaID");
                if (r.getReferencaID() != referencaIDSledeca) {
                    vrati.add(r);
                    r = new Referenca();
                }
                rs.previous();
            }

        }
        vrati.add(r);

        rs.close();
        return vrati;
    }

    public String vratiAutore() {
        String vrati = "";
        for (SpoljniAutor autor : listaSpoljnihAutora) {
            vrati += autor.getImePrezime() + ", ";
        }
        if (vrati != "") {
            vrati = vrati.substring(0, vrati.length() - 2);
        }

        return vrati;
    }

    public String vratiNastavnike() {
        String vrati = "";
        for (Nastavnik nastavnik : listaNastavnika) {
            vrati += nastavnik.getImePrezime() + ", ";
        }
        if (!vrati.equals("")) {
            vrati = vrati.substring(0, vrati.length() - 2);
        }

        return vrati;
    }

    private boolean sadrziNastavnika(Referenca r, Nastavnik n) {
        for (Nastavnik nas : r.getListaNastavnika()) {
            if (nas.getNastavnikID() == n.getNastavnikID()) {
                return true;
            }
        }
        return false;
    }

    private boolean sadrziAutora(Referenca r, SpoljniAutor sa) {
        for (SpoljniAutor spoljniAutor : r.getListaSpoljnihAutora()) {
            if (spoljniAutor.getAutorID() == sa.getAutorID()) {
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

    @Override
    public String getOrderByColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereEqualsColumnsSingle2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
