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
public class Rezervacija extends AbstractObjekat{
    private Projekcija projekcija;
    private int rezervacijaID;
    private String nazivRezervacije;
    private Radnik radnik;

    public Rezervacija() {
    }

    public Rezervacija(Projekcija projekcija, int rezervacijaID, String nazivRezervacije, Radnik radnik) {
        this.projekcija = projekcija;
        this.rezervacijaID = rezervacijaID;
        this.nazivRezervacije = nazivRezervacije;
        this.radnik = radnik;
    }

    public Projekcija getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(Projekcija projekcija) {
        this.projekcija = projekcija;
    }

    public int getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(int rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    public String getNazivRezervacije() {
        return nazivRezervacije;
    }

    public void setNazivRezervacije(String nazivRezervacije) {
        this.nazivRezervacije = nazivRezervacije;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "projekcija=" + projekcija + ", rezervacijaID=" + rezervacijaID + ", nazivRezervacije=" + nazivRezervacije + ", radnik=" + radnik + '}';
    }
 
    @Override
    public String vratiImeTabele() {
        return "rezervacija";
    }

    @Override
    public String vratiParametre() {
        return  getProjekcija().getProjekcijaID() + ", " + rezervacijaID + ", '" + nazivRezervacije + "', " + getRadnik().getRadnikID() + "" ;
    }

    @Override
    public String vratiPK() {
        return "nema";
    }

    @Override
    public int vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> rezervacije = new ArrayList<>();
        try {
            while (rs.next()) {
                int projekcijaID = rs.getInt("projekcijaID");
                int rezervacijaID = rs.getInt("rezervacijaID");
                String nazivRezervacije = rs.getString("nazivRezervacije");
                int radnikID = rs.getInt("radnikID");
                Rezervacija r = new Rezervacija(new Projekcija(projekcijaID, null, null, null, null), rezervacijaID, nazivRezervacije, new Radnik(radnikID, null, null, null, null));
                rezervacije.add(r);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return rezervacije;
    }

    @Override
    public String vratiUpdateUpit() {
        return "projekcijaID=" + getProjekcija().getProjekcijaID()
                + ",rezervacijaID=" + rezervacijaID
                + ",nazivRezervacije='" + nazivRezervacije
                + "',radnikID=" + getRadnik().getRadnikID() + "";
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE projekcijaID= '" + getProjekcija().getProjekcijaID() + "' AND rezervacijaID='" + getRezervacijaID()+ "'";
    }

}
