/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Nastavnik;
import domen.Predaje;
import domen.Predmet;
import domen.StudijskiProgram;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.KontrolerKlijent;
import modeli.ModelTabelePredaje;
import modeli.ModelTabelePretragaNastavnik;
import modeli.ModelTabeleStudijskiProgram;

/**
 *
 * @author Luka
 */
public class UnosNovogPredmetaForma extends javax.swing.JFrame {

    
    private Predmet predmet;
    private List<StudijskiProgram> listaStudijskihPrograma;
    private List<Nastavnik> listaNastavnikaPretraga;
    
    /**
     * Creates new form UnosNovogPredmetaForma
     */
    public UnosNovogPredmetaForma() {
        initComponents();
        setLocationRelativeTo(null);
        predmet = new Predmet();
        inicijalizujListe();
        inicijalizujTabele();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboStudijskiProgram = new javax.swing.JComboBox();
        txtNazivPredmeta = new javax.swing.JTextField();
        btnDodajStudijskiProgram = new javax.swing.JButton();
        btnIzbaciStudijskiProgram = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaStudijskiProgrami = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtImePrezimeProfeosora = new javax.swing.JTextField();
        btnPretraziProfesore = new javax.swing.JButton();
        btnVratiSveProfesore = new javax.swing.JButton();
        btnDodajPredavanje = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaNastavniciPretraga = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBrojCasova = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaDodataPredavanja = new javax.swing.JTable();
        btnIzbaciPredavanje = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnNazad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos novog predmeta"));

        jLabel1.setText("Naziv predmeta:");

        jLabel2.setText("Studijski program:");

        comboStudijskiProgram.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDodajStudijskiProgram.setText("Dodaj studijski program");
        btnDodajStudijskiProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajStudijskiProgramActionPerformed(evt);
            }
        });

        btnIzbaciStudijskiProgram.setText("Izbaci studijski program");
        btnIzbaciStudijskiProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciStudijskiProgramActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dodati studijski programi"));

        tabelaStudijskiProgrami.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaStudijskiProgrami);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Profesori"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretrazi profesore"));

        jLabel3.setText("Ime i prezime:");

        btnPretraziProfesore.setText("Pretrazi");
        btnPretraziProfesore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziProfesoreActionPerformed(evt);
            }
        });

        btnVratiSveProfesore.setText("Vrati sve");
        btnVratiSveProfesore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiSveProfesoreActionPerformed(evt);
            }
        });

        btnDodajPredavanje.setText("Dodaj");
        btnDodajPredavanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPredavanjeActionPerformed(evt);
            }
        });

        tabelaNastavniciPretraga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaNastavniciPretraga);

        jLabel4.setText("Broj casova:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtImePrezimeProfeosora, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPretraziProfesore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVratiSveProfesore))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtBrojCasova, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDodajPredavanje)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtImePrezimeProfeosora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretraziProfesore)
                    .addComponent(btnVratiSveProfesore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBrojCasova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajPredavanje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Dodati profesori"));

        tabelaDodataPredavanja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelaDodataPredavanja);

        btnIzbaciPredavanje.setText("Izbaci");
        btnIzbaciPredavanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciPredavanjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnIzbaciPredavanje)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIzbaciPredavanje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnNazad.setText("Nazad");
        btnNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNazivPredmeta)
                                    .addComponent(comboStudijskiProgram, 0, 200, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajStudijskiProgram)
                                .addGap(18, 18, 18)
                                .addComponent(btnIzbaciStudijskiProgram)))
                        .addGap(82, 82, 82)
                        .addComponent(btnSacuvaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnNazad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivPredmeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboStudijskiProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDodajStudijskiProgram)
                    .addComponent(btnIzbaciStudijskiProgram)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnNazad))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNazadActionPerformed
        KontrolerKlijent.getInstance().setTrenutnaForma("glavnaKlijentForma");
        KontrolerKlijent.getInstance().prikaziGlavnuKlijentFormu("unosPredmetaForma");
    }//GEN-LAST:event_btnNazadActionPerformed

    private void btnDodajStudijskiProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajStudijskiProgramActionPerformed
        StudijskiProgram sp = (StudijskiProgram) comboStudijskiProgram.getSelectedItem();
        if (!sadrziStudijskiProgram(sp)) {
            predmet.getListaStudijskihPrograma().add(sp);
            osveziTabele();
        } else {
            JOptionPane.showMessageDialog(this, "Studijski program je vec dodat!");
        }
    }//GEN-LAST:event_btnDodajStudijskiProgramActionPerformed

    private void btnIzbaciStudijskiProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciStudijskiProgramActionPerformed
        int row = tabelaStudijskiProgrami.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Morate izabrati studijski program!");
        } else {
            StudijskiProgram sp = predmet.getListaStudijskihPrograma().remove(row);
            osveziTabele();
        }
    }//GEN-LAST:event_btnIzbaciStudijskiProgramActionPerformed

    private void btnPretraziProfesoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziProfesoreActionPerformed
        String imePrezime = txtImePrezimeProfeosora.getText();
        KontrolerKlijent.getInstance().pretraziNastavnike(imePrezime);
    }//GEN-LAST:event_btnPretraziProfesoreActionPerformed

    private void btnVratiSveProfesoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiSveProfesoreActionPerformed
        KontrolerKlijent.getInstance().pretraziNastavnike("");
    }//GEN-LAST:event_btnVratiSveProfesoreActionPerformed

    private void btnDodajPredavanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPredavanjeActionPerformed
        int row = tabelaNastavniciPretraga.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Morate izabrati nastavnika");
        } else {
            String brojCasovaString = txtBrojCasova.getText();
            int brojCasova = 0;
            try {
                brojCasova = Integer.parseInt(brojCasovaString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Broj casova mora biti broj!");
                return;
            }
            Nastavnik n = listaNastavnikaPretraga.get(row);
            if (!sadrziNastavnika(n)) {
                predmet.getListaPredavanja().add(new Predaje(n, predmet, brojCasova));
                osveziTabele();
            } else {
                JOptionPane.showMessageDialog(this, "Nastavnik je vec dodat!");
            }
        }
    }//GEN-LAST:event_btnDodajPredavanjeActionPerformed

    private void btnIzbaciPredavanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciPredavanjeActionPerformed
        int row = tabelaDodataPredavanja.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Morate izabrati nastavnika");
        } else {
            predmet.getListaPredavanja().remove(row);
            osveziTabele();
        }
    }//GEN-LAST:event_btnIzbaciPredavanjeActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        String nazivPredmeta = txtNazivPredmeta.getText();
        if (predmet.getListaStudijskihPrograma().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti bar jedan studijski program!");
            return;
        }
        if (nazivPredmeta.equals("")) {
            JOptionPane.showMessageDialog(this, "Naziv predmeta ne sme biti prazan!");
        } else {
            predmet.setNaziv(nazivPredmeta);
            KontrolerKlijent.getInstance().unesiPredmet(predmet);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UnosNovogPredmetaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnosNovogPredmetaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnosNovogPredmetaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnosNovogPredmetaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnosNovogPredmetaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajPredavanje;
    private javax.swing.JButton btnDodajStudijskiProgram;
    private javax.swing.JButton btnIzbaciPredavanje;
    private javax.swing.JButton btnIzbaciStudijskiProgram;
    private javax.swing.JButton btnNazad;
    private javax.swing.JButton btnPretraziProfesore;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnVratiSveProfesore;
    private javax.swing.JComboBox comboStudijskiProgram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaDodataPredavanja;
    private javax.swing.JTable tabelaNastavniciPretraga;
    private javax.swing.JTable tabelaStudijskiProgrami;
    private javax.swing.JTextField txtBrojCasova;
    private javax.swing.JTextField txtImePrezimeProfeosora;
    private javax.swing.JTextField txtNazivPredmeta;
    // End of variables declaration//GEN-END:variables

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public List<StudijskiProgram> getListaStudijskihPrograma() {
        return listaStudijskihPrograma;
    }

    public void setListaStudijskihPrograma(List<StudijskiProgram> listaStudijskihPrograma) {
        this.listaStudijskihPrograma = listaStudijskihPrograma;
    }

    public List<Nastavnik> getListaNastavnikaPretraga() {
        return listaNastavnikaPretraga;
    }

    public void setListaNastavnikaPretraga(List<Nastavnik> listaNastavnikaPretraga) {
        this.listaNastavnikaPretraga = listaNastavnikaPretraga;
    }

    private void inicijalizujListe() {
        listaNastavnikaPretraga = new ArrayList<>();
        listaStudijskihPrograma = new ArrayList<>();
    }

    private void inicijalizujTabele() {
        ModelTabelePretragaNastavnik modelTabelePretragaNastavnik = new ModelTabelePretragaNastavnik();
        modelTabelePretragaNastavnik.setForma("unosPredmetaForma");
        tabelaNastavniciPretraga.setModel(modelTabelePretragaNastavnik);
        
        ModelTabelePredaje modelTabelePredaje = new ModelTabelePredaje();
        modelTabelePredaje.setForma("unosPredmetaForma");
        tabelaDodataPredavanja.setModel(modelTabelePredaje);
        
        ModelTabeleStudijskiProgram modelTabeleStudijskiProgram = new ModelTabeleStudijskiProgram();
        modelTabeleStudijskiProgram.setForma("unosPredmetaForma");
        tabelaStudijskiProgrami.setModel(modelTabeleStudijskiProgram);
    }

    public void podesiFormu() {
        comboStudijskiProgram.removeAllItems();
        for (StudijskiProgram sp : listaStudijskihPrograma) {
            comboStudijskiProgram.addItem(sp);
        }
    }

    private boolean sadrziStudijskiProgram(StudijskiProgram sp) {
        for (StudijskiProgram studijskiProgram : predmet.getListaStudijskihPrograma()) {
            if (studijskiProgram.getProgramID() == sp.getProgramID()) {
                return true;
            }
        }
        return false;
    }

    public void osveziTabele() {
        ModelTabelePretragaNastavnik modelTabelePretragaNastavnik = (ModelTabelePretragaNastavnik) tabelaNastavniciPretraga.getModel();
        ModelTabelePredaje modelTabelePredaje = (ModelTabelePredaje) tabelaDodataPredavanja.getModel();
        ModelTabeleStudijskiProgram modelTabeleStudijskiProgram = (ModelTabeleStudijskiProgram) tabelaStudijskiProgrami.getModel();
        
        modelTabelePretragaNastavnik.fireTableDataChanged();
        modelTabelePredaje.fireTableDataChanged();
        modelTabeleStudijskiProgram.fireTableDataChanged();
    }

    private boolean sadrziNastavnika(Nastavnik n) {
        for (Predaje predaje : predmet.getListaPredavanja()) {
            if (predaje.getNastavnik().getNastavnikID() == n.getNastavnikID()) {
                return true;
            }
        }
        return false;
    }

    public void uspesnoUnetPredmet(boolean uspesnoUnetPredmet) {
        if (uspesnoUnetPredmet) {
            JOptionPane.showMessageDialog(this, "Uspesno unet predmet u bazu.");
        } else {
            JOptionPane.showMessageDialog(this, "Greska prilikom unosa predmeta u bazu.");
        }
    }

    
    
}
