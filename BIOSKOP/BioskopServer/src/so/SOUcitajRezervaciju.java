/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Projekcija;
import domen.Radnik;
import domen.Rezervacija;
import java.sql.SQLException;

/**
 *
 * @author Nina777
 */
public class SOUcitajRezervaciju extends AbstractSO {

    AbstractObjekat rezervacija;
    int id;

    public SOUcitajRezervaciju(int id) {
        this.id = id;
        rezervacija = new Rezervacija();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            rezervacija = db.vratiObjekatPoKljucu(new Rezervacija(), id);
            System.out.println(rezervacija);
            Rezervacija rez = (Rezervacija) rezervacija;
            Projekcija p = (Projekcija) db.vratiObjekatPoKljucu(new Projekcija(), rez.getProjekcija().getProjekcijaID());
            rez.setProjekcija(p);
            System.out.println(p);
            Radnik r = (Radnik) db.vratiObjekatPoKljucu(new Radnik(), rez.getRadnik().getRadnikID());
            rez.setRadnik(r);
            System.out.println(r);
            rezervacija = rez;

        } catch (SQLException ex) {
            System.out.println("Nije pronadjena rezervacija po id " + id);
        }
    }

    public AbstractObjekat vratiRezervaciju() {
        return rezervacija;
    }
}
