/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Projekcija;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author Nina777
 */
public class SOZapamtiFilm extends AbstractSO {

    AbstractObjekat film;
    List<AbstractObjekat> projekcije;

    public SOZapamtiFilm(AbstractObjekat film, List<AbstractObjekat> projekcije) {
        this.film = film;
//        Film f = (Film) film;
//        int id = Kontroler.vratiMaxFilm(f);
//        f.setFilmID(id+1);
//        for (AbstractObjekat ao : projekcije) {
//            Projekcija p = (Projekcija) ao;
//            p.setFilm(f);
//        }
        this.projekcije = projekcije;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            db.sacuvajIliAzurirajObjekat(film);
            Film f = (Film) film;
            int id = Kontroler.vratiMaxFilm(f);
            f.setFilmID(id + 1);
            for (AbstractObjekat ao : projekcije) {
                Projekcija p = (Projekcija) ao;
                p.setFilm(f);
            }
            db.sacuvajObjekte(projekcije);
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
