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
 * @author Nina777
 */
public class Karta extends AbstractObjekat{
    private Projekcija projekcija;
    private int kartaID;
    private double cena;
    private Radnik radnik;
    private Sediste sediste;

    public Karta() {
    }

    public Karta(Projekcija projekcija, int kartaID, double cena, Radnik radnik, Sediste sediste) {
        this.projekcija = projekcija;
        this.kartaID = kartaID;
        this.cena = cena;
        this.radnik = radnik;
        this.sediste = sediste;
    }

    

    public Projekcija getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(Projekcija projekcija) {
        this.projekcija = projekcija;
    }

    public int getKartaID() {
        return kartaID;
    }

    public void setKartaID(int kartaID) {
        this.kartaID = kartaID;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Sediste getSediste() {
        return sediste;
    }

    public void setSediste(Sediste sediste) {
        this.sediste = sediste;
    }

    @Override
    public String toString() {
        return "Karta{" + "projekcija=" + projekcija + ", kartaID=" + kartaID + ", cena=" + cena + ", radnik=" + radnik + ", sediste=" + sediste + '}';
    }

  @Override
    public String vratiImeTabele() {
        return "karta";
    }

    @Override
    public String vratiParametre() {
        return getProjekcija().getProjekcijaID() + ", " + kartaID + ", " + cena + ", " + getRadnik().getRadnikID() + ", " + getSediste().getSala().getSalaID()+ ", "  + getSediste().getRed() + ", " +  getSediste().getBrojSedista() + "" ;
    }

    @Override
    public String vratiPK() {
        return "kartaID";
    }

    @Override
    public int vratiVrednostPK() {
        return -1;
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> karte = new ArrayList<>();
        try {
            while (rs.next()) {
                int projekcijaID = rs.getInt("projekcijaID");
                int kartaID = rs.getInt("kartaID");
                Double cena = rs.getDouble("cena");
                int radnikID = rs.getInt("radnikID");
                int salaID = rs.getInt("salaID");
                int red = rs.getInt("red");
                int brojSedista = rs.getInt("brojSedista");
                Karta k = new Karta(new Projekcija(projekcijaID, null, null, null, null), kartaID, cena, new Radnik(radnikID, null, null, null, null), new Sediste(new Sala(salaID, null, 0), red, brojSedista));
                karte.add(k);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return karte;
    }

    @Override
    public String vratiUpdateUpit() {
        return "projekcijaID=" + getProjekcija().getProjekcijaID()
                + ",kartaID=" + kartaID
                + ",cena=" + cena
                + ",radnikID=" + getRadnik().getRadnikID()
                + ",sediste=" + getSediste().getSala().getSalaID()
                + ",red=" + getSediste().getRed()
                + ",brojSedista=" + getSediste().getBrojSedista()+ "";// vrati slozen pk
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE projekcijaID= " + getProjekcija().getProjekcijaID() + " AND kartaID=" + getKartaID()+"";
    }
}
