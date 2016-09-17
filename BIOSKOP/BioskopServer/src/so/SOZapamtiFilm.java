/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class SOZapamtiFilm extends AbstractSO {

    AbstractObjekat film;
    List<AbstractObjekat> projekcije;

    public SOZapamtiFilm(AbstractObjekat film, List<AbstractObjekat> projekcije) {
        this.film = film;
        this.projekcije = projekcije;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            db.sacuvajIliAzurirajObjekat(film);
            for (AbstractObjekat ao : projekcije) {
                db.sacuvajIliAzurirajObjekat(ao);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
