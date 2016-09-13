/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.AbstractObjekat;

/**
 *
 * @author Nina777
 */
public class SOKreirajNoviFilm extends AbstractSO {

    AbstractObjekat film;
    private int id;

    public SOKreirajNoviFilm(AbstractObjekat film) {
        this.film = film;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        id = DBBroker.vratiInstancu().vratiMaksID(film);
    }

    public int getId() {
        return id;
    }
}
