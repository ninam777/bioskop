/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class Sala extends AbstractObjekat{
    private int salaID;
    private String nazivSale;
    private int kapacitet;

    public Sala() {
    }

    public Sala(int salaID, String nazivSale, int kapacitet) {
        this.salaID = salaID;
        this.nazivSale = nazivSale;
        this.kapacitet = kapacitet;
    }

    public int getSalaID() {
        return salaID;
    }

    public void setSalaID(int salaID) {
        this.salaID = salaID;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public String toString() {
        return "Sala{" + "salaID=" + salaID + ", nazivSale=" + nazivSale + ", kapacitet=" + kapacitet + '}';
    }
    
    @Override
    public String vratiImeTabele() {
        return "sala";
    }

    @Override
    public String vratiParametre() {
        return salaID + ", '" + nazivSale + "', " + kapacitet + "" ;
    }

    @Override
    public String vratiPK() {
        return "salaID";
    }

    @Override
    public int vratiVrednostPK() {
        return salaID;
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> sale = new ArrayList<>();
        try {
            while (rs.next()) {
                int salaID = rs.getInt("salaID");
                String nazivSale = rs.getString("nazivSale");
                int kapacitet = rs.getInt("kapacitet");
                Sala s = new Sala(salaID, nazivSale, kapacitet);
                sale.add(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return sale;
    }

    @Override
    public String vratiUpdateUpit() {
        return "salaID=" + salaID
                + ",nazivSale='" + nazivSale
                + "',kapacitet=" + kapacitet + "";
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema";
    }

}
