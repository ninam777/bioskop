/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class SOObrisiFilm extends AbstractSO {

    AbstractObjekat film;

    public SOObrisiFilm(AbstractObjekat film) {
        this.film = film;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            db.obrisiObjekat(film);
        } catch (Exception ex) {
            Logger.getLogger(SOObrisiFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
