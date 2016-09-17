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
public class SOKreirajNoveKarte extends AbstractSO {

    AbstractObjekat karta;
    private int id;

    public SOKreirajNoveKarte(AbstractObjekat karta) {
        this.karta = karta;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        id = db.vratiMaksID(karta);
    }

    public int getId() {
        return id;
    }
}
