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
public class Film extends AbstractObjekat{
    private int filmID;
    private String nazivFilma;
    private String zanr;
    private int trajanje;
    private String reziser;
    private String glumci;
    private String opis;
    private String periodPrikazivanja;
    private Radnik radnik;

    public Film() {
    }

    public Film(int filmID, String nazivFilma, String zanr, int trajanje, String reziser, String glumci, String opis, String periodPrikazivanja, Radnik radnik) {
        this.filmID = filmID;
        this.nazivFilma = nazivFilma;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.reziser = reziser;
        this.glumci = glumci;
        this.opis = opis;
        this.periodPrikazivanja = periodPrikazivanja;
        this.radnik = radnik;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getGlumci() {
        return glumci;
    }

    public void setGlumci(String glumci) {
        this.glumci = glumci;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getPeriodPrikazivanja() {
        return periodPrikazivanja;
    }

    public void setPeriodPrikazivanja(String periodPrikazivanja) {
        this.periodPrikazivanja = periodPrikazivanja;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public String toString() {
        return "Film{" + "filmID=" + filmID + ", nazivFilma=" + nazivFilma + ", zanr=" + zanr + ", trajanje=" + trajanje + ", reziser=" + reziser + ", glumci=" + glumci + ", opis=" + opis + ", periodPrikazivanja=" + periodPrikazivanja + ", radnik=" + radnik + '}';
    }
    
    @Override
    public String vratiImeTabele() {
        return "film";
    }

    @Override
    public String vratiParametre() {
        return filmID + ", '" + nazivFilma + "', '" + zanr + "', " + trajanje + ", '" + reziser+ "', '"  + glumci + "', '" + opis + "', '" + periodPrikazivanja + "', " +  getRadnik().getRadnikID() + "" ;
    }

    @Override
    public String vratiPK() {
        return "filmID";
    }

    @Override
    public int vratiVrednostPK() {
        return filmID;
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> filmovi = new ArrayList<>();
        try {
            while (rs.next()) {
                int filmID = rs.getInt("filmID");
                String nazivFilma = rs.getString("nazivFilma");
                String zanr = rs.getString("zanr");
                int trajanje = rs.getInt("trajanje");
                String reziser = rs.getString("reziser");
                String glumci = rs.getString("glumci");
                String opis = rs.getString("opis");
                String periodPrikazivanja = rs.getString("periodPrikazivanja");
                int radnikID = rs.getInt("radnikID");
                Film f = new Film(filmID, nazivFilma, zanr, trajanje, reziser, glumci, opis, periodPrikazivanja, new Radnik(radnikID, null, null, null, null));
                filmovi.add(f);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return filmovi;
    }

    @Override
    public String vratiUpdateUpit() {
        return "nazivFilma='" + nazivFilma
                + "',zanr='" + zanr
                + "',trajanje=" + trajanje
                + ",reziser='" + reziser
                + "',glumci='" + glumci
                + "',opis='" + opis
                + "',periodPrikazivanja='" + periodPrikazivanja
                + "',radnikID=" + getRadnik().getRadnikID() + "";
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema";
    }
}
