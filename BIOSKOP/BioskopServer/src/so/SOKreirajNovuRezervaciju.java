/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;

/**
 *
 * @author Nina777
 */
public class SOKreirajNovuRezervaciju extends AbstractSO {

    AbstractObjekat rezervacija;
    private int id;

    public SOKreirajNovuRezervaciju(AbstractObjekat rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        id = db.vratiMaksID(rezervacija);
    }

    public int getId() {
        return id;
    }
}
