/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.AbstractObjekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBroker {

    private Connection konekcija;
    private static DBBroker instance;

    public DBBroker() {
    }

    public static DBBroker vratiInstancu() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

//    public void uspostaviKonekcijuMySql() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver ucitan");
//            String url = "jdbc:mysql://localhost:3306/arrentacar";
//            String user = "sluzbenik";
//            String pass = "sluzbenik";
//            konekcija = DriverManager.getConnection(url, user, pass);
//            konekcija.setAutoCommit(false);
//            System.out.println("Uspesna konekcija.");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Driver nije pronadjen.");
//        } catch (SQLException ex) {
//            System.out.println("Nije uspostavljena konekcija sa bazom.");
//        }
//    }
//
//    public void raskiniKonekciju() {
//        try {
//            konekcija.close();
//        } catch (SQLException ex) {
//            System.out.println("Ne moze da se raskine konekcija.");
//        }
//    }
//
//    public void commit() {
//        try {
//            konekcija.commit();
//        } catch (SQLException ex) {
//            System.out.println("Neuspesan commit.");
//        }
//    }
//
//    public void rollback() {
//        try {
//            konekcija.rollback();
//        } catch (SQLException ex) {
//            System.out.println("Neuspesan rollback.");
//        }
//    }
    public void ucitajDrajver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nije se ucitao drajver");
        }
    }

    public void otvoriKonekciju() {
        try {
            // TODO: promeni ime baze ako treba, ako postoji grupa pogledaj
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/bioskop", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Nije otvorena konekcija");
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void komit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AbstractObjekat> vratiSveObjekte(AbstractObjekat o) throws SQLException {
        try {
            List<AbstractObjekat> lista = new ArrayList<>();
            String upit = "SELECT * FROM " + o.vratiImeTabele();
            java.sql.Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            lista = o.izRSuTabelu(rs);
            s.close();
//            System.out.println("Prosao.");
            return lista;
        } catch (SQLException ex) {
            System.out.println("Greska u vracanju");
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public AbstractObjekat vratiObjekatPoKljucu(AbstractObjekat o, int id) throws SQLException {
        String upit = "";

        if (o.vratiPK() != null) {
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "='" + id + "'";
        } else {
            upit = "SELECT * FROM " + o.vratiImeTabele() + o.vratiSlozenPK();
        }

        Statement s = (Statement) konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        List<AbstractObjekat> lista = new ArrayList<>();
        lista = o.izRSuTabelu(rs);
        s.close();
        return lista.get(0);
    }

    public AbstractObjekat obrisiObjekat(AbstractObjekat o) throws Exception {
        String upit = "";

//        if (o.vratiPK() != null) {
        if (o.vratiVrednostPK() != -1) {
            upit = "DELETE FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "=" + o.vratiVrednostPK();

        } else {
            upit = "DELETE FROM " + o.vratiImeTabele() + o.vratiSlozenPK();

        }
        Statement s = (Statement) konekcija.createStatement();
        System.out.println("4. UPIT: " + upit + "#");
        s.executeUpdate(upit);
        komit();
        s.close();
        return o;
    }

    public void obrisiObjekte(List<AbstractObjekat> lista) throws Exception {
        for (AbstractObjekat o : lista) {
            obrisiObjekat(o);
        }
    }

    public AbstractObjekat sacuvajIliAzurirajObjekat(AbstractObjekat o) throws SQLException {
        List<AbstractObjekat> lista = vratiSveObjekte(o);
        boolean found = false;
        boolean slozenKljuc = false;
        for (AbstractObjekat ao : lista) {
//            if(a.getPrimaryKeyValue() == o.getPrimaryKeyValue()){
//            System.out.println("vrednost pk "+ ao.vratiVrednostPK() + " *** "+ o.vratiVrednostPK());
            if (o.vratiVrednostPK() == -1) {
                slozenKljuc = true;
            } else if (ao.vratiVrednostPK() == o.vratiVrednostPK()) {
                found = true;
            }
        }
        if (slozenKljuc) {
            if (lista.contains(o)) {
                found = true;
            }
        }
        System.out.println("USAO u sacuvaj ili azuriraj");
        String upit = "";
//        if (!lista.contains(o)) {
        if (!found) {
            upit = "INSERT INTO " + o.vratiImeTabele() + " VALUES (" + o.vratiParametre() + ")";
            System.out.println("1.UPIT: " + upit);
        } else {
            if (o.getStatus() == -1) {
                upit = "DELETE FROM " + o.vratiImeTabele() + o.vratiSlozenPK();
                System.out.println("UPIT: " + upit);

            } else {
                if (o.vratiPK() != null) {

                    upit = "UPDATE " + o.vratiImeTabele() + " SET " + o.vratiUpdateUpit() + " WHERE " + o.vratiPK() + "=" + o.vratiVrednostPK();
                    System.out.println("2.UPIT: " + upit);
                } else {

                    upit = "UPDATE " + o.vratiImeTabele() + " SET " + o.vratiUpdateUpit() + o.vratiSlozenPK();
                    System.out.println("3.UPIT: " + upit);
                }
            }

        }

        Statement s = (Statement) konekcija.createStatement();
        int i = s.executeUpdate(upit);
        s.close();
        return o;
    }

    public AbstractObjekat sacuvajObjekat(AbstractObjekat o) throws SQLException {

        String upit = "";
        System.out.println("Usao u sacuvaj");
        upit = "INSERT INTO " + o.vratiImeTabele() + " VALUES (" + o.vratiParametre() + ")";
        Statement s = (Statement) konekcija.createStatement();
        int i = s.executeUpdate(upit);
        s.close();
        return o;
    }

    public void sacuvajObjekte(List<AbstractObjekat> lista) throws SQLException {
        for (AbstractObjekat ao : lista) {
            sacuvajIliAzurirajObjekat(ao);
        }
    }

    public int vratiMaksID(AbstractObjekat ao) {
        //TODO pogledaj kako vraca zato sto ti je ID string a ne int IDIOTE GLUPI
//        int id = Integer.parseInt(ao.vratiPK());
        String query = "Select max(" + ao.vratiPK() + ") as maks from " + ao.vratiImeTabele();
//        String query = "Select max(" + id + ") as maks from " + ao.vratiImeTabele();
//        String query = "Select count(*) as maks from " + ao.vratiImeTabele();
        int maks = 0;
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(query);
            System.out.println(query);
            while (rs.next()) {
                maks = rs.getInt("maks");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maks;
    }
}
