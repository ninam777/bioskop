/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Karta;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author nikolinam
 */
public class SOZapamtiKarteZaRezervisanoSediste  extends AbstractSO {

    List<AbstractObjekat> karte;

    public SOZapamtiKarteZaRezervisanoSediste(List<AbstractObjekat> karte) {
        this.karte = karte;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            db.sacuvajObjekte(karte);
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiKarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}