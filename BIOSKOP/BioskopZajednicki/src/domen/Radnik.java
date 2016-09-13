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
public class Radnik extends AbstractObjekat{
    private int radnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public Radnik() {
    }

    public Radnik(int radnikID, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @Override
    public String toString() {
        return "Radnik{" + "radnikID=" + radnikID + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", korisnickaSifra=" + korisnickaSifra + '}';
    }
    
    @Override
    public String vratiImeTabele() {
        return "radnik";
    }

    @Override
    public String vratiParametre() {
        return radnikID + ", '" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + korisnickaSifra+ "'" ;
    }

    @Override
    public String vratiPK() {
        return "radnikID";
    }

    @Override
    public int vratiVrednostPK() {
        return radnikID;
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> radnici = new ArrayList<>();
        try {
            while (rs.next()) {
                int radnikID = rs.getInt("radnikID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String korisnickoIme = rs.getString("korisnickoIme");
                String korisnickaSifra = rs.getString("korisnickaSifra");
                Radnik r = new Radnik(radnikID, ime, prezime, korisnickoIme, korisnickaSifra);
                radnici.add(r);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return radnici;
    }

    @Override
    public String vratiUpdateUpit() {
        return "radnikID=" + radnikID
                + ",ime='" + ime
                + "',prezime='" + prezime
                + "',korisnickoIme='" + korisnickoIme
                + "',korisnickaSifra='" + korisnickaSifra + "'";
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema";
    }

}
