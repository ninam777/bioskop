/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObjekat;
import domen.Film;
import domen.Rezervacija;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import kontroler.Kontroler;
import model.ModelTabeleFilm;
import model.ModelTabeleRezervacija;
import model.ModelTabeleVremenaProjekcija;
import osvezi.NitOsvezi;
import sesija.Sesija;
import start.KlijentStart;

/**
 *
 * @author Nina777
 */
public class FormaRepertoar extends javax.swing.JFrame {

    Kontroler k;

    /**
     * Creates new form FormaRepertoar
     */
    public FormaRepertoar(java.awt.Frame parent, boolean modal) {
//        super(parent, modal);
//        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

//        Sesija.vratiInstancu().getMapa().put("nacin", "unos");
        initComponents();

    }

    FormaRepertoar() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        Sesija.vratiInstancu().getMapa().put("nacin", "prikaz");
        initComponents();
        k = new Kontroler();
        try {
            srediFormu();
//            NitOsvezi no = new NitOsvezi(this);
//            no.start();
        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpRiR = new javax.swing.JTabbedPane();
        jpRepertoar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfFilterFilm = new javax.swing.JTextField();
        btnPronadjiFilm = new javax.swing.JButton();
        btnDodajFilm = new javax.swing.JButton();
        btnIzmeniFilm = new javax.swing.JButton();
        btnObrisiFilm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFilmovi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnKupi = new javax.swing.JButton();
        btnRezervisi = new javax.swing.JButton();
        jpRezervacije = new javax.swing.JPanel();
        btnPretrazi = new javax.swing.JButton();
        jtfFilterRezervacije = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnKupiKarte = new javax.swing.JButton();
        btnObrisiRezervaciju = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRezervacije = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bioskop");

        jLabel1.setText("Filter:");

        btnPronadjiFilm.setText("Pronađi film");
        btnPronadjiFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiFilmActionPerformed(evt);
            }
        });

        btnDodajFilm.setText("Dodaj");
        btnDodajFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajFilmActionPerformed(evt);
            }
        });

        btnIzmeniFilm.setText("Izmeni");
        btnIzmeniFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniFilmActionPerformed(evt);
            }
        });

        btnObrisiFilm.setText("Obriši");
        btnObrisiFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiFilmActionPerformed(evt);
            }
        });

        jtFilmovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtFilmovi);

        jLabel2.setText("Filmovi");

        btnKupi.setText("Kupi karte");
        btnKupi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKupiActionPerformed(evt);
            }
        });

        btnRezervisi.setText("Rezerviši");
        btnRezervisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRepertoarLayout = new javax.swing.GroupLayout(jpRepertoar);
        jpRepertoar.setLayout(jpRepertoarLayout);
        jpRepertoarLayout.setHorizontalGroup(
            jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRepertoarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRepertoarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jtfFilterFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPronadjiFilm))
                    .addGroup(jpRepertoarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(70, 70, 70)
                        .addComponent(btnDodajFilm)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeniFilm)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiFilm))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpRepertoarLayout.createSequentialGroup()
                        .addComponent(btnKupi)
                        .addGap(18, 18, 18)
                        .addComponent(btnRezervisi)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jpRepertoarLayout.setVerticalGroup(
            jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRepertoarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfFilterFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPronadjiFilm))
                .addGap(18, 18, 18)
                .addGroup(jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDodajFilm)
                        .addComponent(btnIzmeniFilm)
                        .addComponent(btnObrisiFilm))
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jpRepertoarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKupi)
                    .addComponent(btnRezervisi))
                .addGap(33, 33, 33))
        );

        jtpRiR.addTab("Repertoar", jpRepertoar);

        btnPretrazi.setText("Pretraži rezervacije");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        jLabel3.setText("Filter:");

        btnKupiKarte.setText("Kupi karte");
        btnKupiKarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKupiKarteActionPerformed(evt);
            }
        });

        btnObrisiRezervaciju.setText("Obriši rezervaciju");
        btnObrisiRezervaciju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiRezervacijuActionPerformed(evt);
            }
        });

        jtRezervacije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jtRezervacije);

        jLabel4.setText("Rezervacije");

        javax.swing.GroupLayout jpRezervacijeLayout = new javax.swing.GroupLayout(jpRezervacije);
        jpRezervacije.setLayout(jpRezervacijeLayout);
        jpRezervacijeLayout.setHorizontalGroup(
            jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRezervacijeLayout.createSequentialGroup()
                .addGroup(jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRezervacijeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(36, 36, 36)
                        .addComponent(jtfFilterRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(jpRezervacijeLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKupiKarte)
                        .addGap(27, 27, 27)))
                .addGroup(jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnObrisiRezervaciju)
                    .addComponent(btnPretrazi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpRezervacijeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpRezervacijeLayout.setVerticalGroup(
            jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRezervacijeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfFilterRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi))
                .addGap(18, 18, 18)
                .addGroup(jpRezervacijeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKupiKarte)
                    .addComponent(btnObrisiRezervaciju))
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jtpRiR.addTab("Rezervacije", jpRezervacije);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpRiR, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpRiR, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajFilmActionPerformed
        new FormaPostavljanjeFilma().setVisible(true);
        try {
            srediFormu();
        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajFilmActionPerformed

    private void btnKupiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKupiActionPerformed
        new FormaKupovinaKarata().setVisible(true);
    }//GEN-LAST:event_btnKupiActionPerformed

    private void btnObrisiFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiFilmActionPerformed
//        try {
        ModelTabeleFilm mtf = (ModelTabeleFilm) jtFilmovi.getModel();
        List<Film> filmBrisi = mtf.getLista();
        Film fBrisi = filmBrisi.get(jtFilmovi.getSelectedRow());

        boolean uspesnost;

        try {
            uspesnost = k.obrisiFilm(fBrisi);

            if (uspesnost) {
                JOptionPane.showMessageDialog(this, "Uspesno izbrisan film: " + fBrisi.getNazivFilma());
            } else {
                JOptionPane.showMessageDialog(this, "Nije obrisan film: " + fBrisi.getNazivFilma());
            }

            srediFormu();

        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            JOptionPane.showMessageDialog(this, "Niste odabrali klijenta za brisanje.");
//        }
    }//GEN-LAST:event_btnObrisiFilmActionPerformed

    private void btnObrisiRezervacijuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiRezervacijuActionPerformed
//        try {
        ModelTabeleRezervacija mtr = (ModelTabeleRezervacija) jtRezervacije.getModel();
        List<Rezervacija> rezervacijaBrisi = mtr.getLista();
        Rezervacija rBrisi = rezervacijaBrisi.get(jtRezervacije.getSelectedRow());

        boolean uspesnost;

        try {
            uspesnost = k.obrisiRezervaciju(rBrisi);

            if (uspesnost) {
                JOptionPane.showMessageDialog(this, "Uspesno izbrisana rezervacija: " + rBrisi.getNazivRezervacije());
            } else {
                JOptionPane.showMessageDialog(this, "Nije obrisana rezervacija: " + rBrisi.getNazivRezervacije());
            }
            srediFormu();
        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            JOptionPane.showMessageDialog(this, "Niste odabrali klijenta za brisanje.");
//        }
    }//GEN-LAST:event_btnObrisiRezervacijuActionPerformed

    private void btnRezervisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervisiActionPerformed

        ModelTabeleFilm mtf = (ModelTabeleFilm) jtFilmovi.getModel();
        List<Film> filmovi = mtf.getLista();
        Film f = filmovi.get(jtFilmovi.getSelectedRow());
//        String nazivFilma = f.getNazivFilma();
        Sesija.vratiInstancu().getMapa().put("film", f);
        new FormaRezervacijaKarata().setVisible(true);
    }//GEN-LAST:event_btnRezervisiActionPerformed

    private void btnKupiKarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKupiKarteActionPerformed
        new FormaKupovinaKarata().setVisible(true);
    }//GEN-LAST:event_btnKupiKarteActionPerformed

    private void btnPronadjiFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiFilmActionPerformed
        String filter = jtfFilterFilm.getText().trim();
        List<AbstractObjekat> filmovi = new ArrayList<>();
        ArrayList<Film> lista = new ArrayList<>();
        ModelTabeleFilm mtf = (ModelTabeleFilm) jtFilmovi.getModel();
        try {
            filmovi = k.pretraziFilmove(filter);
            for (AbstractObjekat ao : filmovi) {
                Film f = (Film) ao;
                lista.add(f);
            }
            mtf.setLista(lista);
            jtFilmovi.setModel(mtf);
//            srediFormu();
        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPronadjiFilmActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        String filter = jtfFilterRezervacije.getText().trim();
        List<AbstractObjekat> rezervacije = new ArrayList<>();
        ArrayList<Rezervacija> lista = new ArrayList<>();
        ModelTabeleRezervacija mtr = (ModelTabeleRezervacija) jtRezervacije.getModel();
        try {
            rezervacije = k.pretraziRezervacije(filter);
            for (AbstractObjekat ao : rezervacije) {
                Rezervacija r = (Rezervacija) ao;
                lista.add(r);
            }
            mtr.setLista(lista);
            jtFilmovi.setModel(mtr);
        } catch (IOException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnIzmeniFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniFilmActionPerformed
//        new FormaPostavljanjeFilma().setVisible(true);
//        TODO: dodati podatke

        Sesija.vratiInstancu().getMapa().put("rezim", "izmena");
        int red = jtFilmovi.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(this, "Nije odabran nijedan film.", "Izmena", INFORMATION_MESSAGE);
        } else {
            try {
                int id = (int) jtFilmovi.getValueAt(red, 0);
                Film f = new Film();
//                Klijent kl = new Klijent();
                f = k.vratiFilm(id);
//                kl = k.vratiKlijentaPoID(id);
//                System.out.println(kl.getMesto() + " " + kl.getNaziv());

                Sesija.vratiInstancu().getMapa().put("film", f);
//                new FKlijent().setVisible(true);
                new FormaPostavljanjeFilma().setVisible(true);
//                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormaRepertoar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnIzmeniFilmActionPerformed

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
            java.util.logging.Logger.getLogger(FormaRepertoar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaRepertoar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaRepertoar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaRepertoar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaRepertoar().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajFilm;
    private javax.swing.JButton btnIzmeniFilm;
    private javax.swing.JButton btnKupi;
    private javax.swing.JButton btnKupiKarte;
    private javax.swing.JButton btnObrisiFilm;
    private javax.swing.JButton btnObrisiRezervaciju;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPronadjiFilm;
    private javax.swing.JButton btnRezervisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpRepertoar;
    private javax.swing.JPanel jpRezervacije;
    private javax.swing.JTable jtFilmovi;
    private javax.swing.JTable jtRezervacije;
    private javax.swing.JTextField jtfFilterFilm;
    private javax.swing.JTextField jtfFilterRezervacije;
    private javax.swing.JTabbedPane jtpRiR;
    // End of variables declaration//GEN-END:variables

    public void srediFormu() throws IOException, ClassNotFoundException {
        ModelTabeleFilm mtf = new ModelTabeleFilm();
        ModelTabeleRezervacija mtr = new ModelTabeleRezervacija();

        List<AbstractObjekat> filmovi = new ArrayList<>();
        List<AbstractObjekat> rezervacije = new ArrayList<>();
        ArrayList<Film> listaF = new ArrayList<>();
        ArrayList<Rezervacija> listaR = new ArrayList<>();

        filmovi = k.pretraziFilmove("");
        rezervacije = k.pretraziRezervacije("");

        for (AbstractObjekat ao : filmovi) {
            Film f = (Film) ao;
            listaF.add(f);
        }

        for (AbstractObjekat ao : rezervacije) {
            Rezervacija r = (Rezervacija) ao;
            listaR.add(r);
        }

        mtf.setLista(listaF);
        mtr.setLista(listaR);

        jtFilmovi.setModel(mtf);
        jtRezervacije.setModel(mtr);
    }
}
