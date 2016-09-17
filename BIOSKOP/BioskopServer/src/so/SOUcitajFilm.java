/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Radnik;
import java.sql.SQLException;

/**
 *
 * @author Nina777
 */
public class SOUcitajFilm extends AbstractSO {

    AbstractObjekat film;
    int id;

    public SOUcitajFilm(int id) {
        this.id = id;
        film = new Film();
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            film = db.vratiObjekatPoKljucu(new Film(), id);
            Film f = (Film) film;
            Radnik r = (Radnik) db.vratiObjekatPoKljucu(new Radnik(), f.getRadnik().getRadnikID());
            f.setRadnik(r);
            film = f;

        } catch (SQLException ex) {
            System.out.println("Nije pronadjen film po id " + id);
        }
    }

    public AbstractObjekat vratiFilm() {
        return film;
    }
}
