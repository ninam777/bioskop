/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class Projekcija extends AbstractObjekat{
    private int projekcijaID;
    private Date datum;
    private Date vreme;
    private Film film;
    private Sala sala;

    public Projekcija() {
    }

    public Projekcija(int projekcijaID, Date datum, Date vreme, Film film, Sala sala) {
        this.projekcijaID = projekcijaID;
        this.datum = datum;
        this.vreme = vreme;
        this.film = film;
        this.sala = sala;
    }

    public int getProjekcijaID() {
        return projekcijaID;
    }

    public void setProjekcijaID(int projekcijaID) {
        this.projekcijaID = projekcijaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return sala + " " + datum + " u " + vreme;
    }
    
    @Override
    public String vratiImeTabele() {
        return "projekcija";
    }

    @Override
    public String vratiParametre() {
        return projekcijaID + ", '" + new java.sql.Date(datum.getTime()) + "', '" + new java.sql.Time(vreme.getTime()) + "', " + getFilm().getFilmID() + ", " + getSala().getSalaID()+ "" ;
    }

    @Override
    public String vratiPK() {
        return "projekcijaID";
    }

    @Override
    public int vratiVrednostPK() {
        return projekcijaID;
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> projekcije = new ArrayList<>();
        try {
            while (rs.next()) {
                int projekcijaID = rs.getInt("projekcijaID");
                Date datum = rs.getDate("datum");
                Time vreme = rs.getTime("vreme");
                int filmID = rs.getInt("filmID");
                int salaID = rs.getInt("salaID");
                Projekcija p = new Projekcija(projekcijaID, datum, vreme, new Film(filmID, null, null, 0, null, null, null, null, null), new Sala(salaID, null, 0));
                projekcije.add(p);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return projekcije;
    }

    @Override
    public String vratiUpdateUpit() {
        return "projekcijaID=" + projekcijaID
                + ",datum='" + new java.sql.Date(datum.getTime())
                + "',vreme='" + new java.sql.Time(vreme.getTime())
                + "',filmID=" + getFilm().getFilmID()
                + ",salaID=" + getSala().getSalaID() + "";
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema";
    }
}
