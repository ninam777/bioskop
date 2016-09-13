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
public class SOZapamtiRezervaciju extends AbstractSO {

    AbstractObjekat rezervacija;
    List<AbstractObjekat> listaRezSedista;

    public SOZapamtiRezervaciju(AbstractObjekat rezervacija, List<AbstractObjekat> listaRezSedista) {
        this.rezervacija = rezervacija;
        this.listaRezSedista = listaRezSedista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            db.sacuvajObjekat(rezervacija);
            db.sacuvajObjekte(listaRezSedista);
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiRezervaciju.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

