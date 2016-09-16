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
 * @author Nina777
 */
public class SOZapamtiKarte extends AbstractSO {

    List<AbstractObjekat> karte;

    public SOZapamtiKarte(List<AbstractObjekat> karte) {
        this.karte = karte;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
//            Rezervacija r = (Rezervacija) rezervacija;
//            int id = Kontroler.vratiMaxRezervacija(r);
//            r.setRezervacijaID(id+1);
//            rezervacija = r;
//            for (AbstractObjekat ao : listaRezSedista) {
//                RezervisanoSediste rs = (RezervisanoSediste) ao;
//                rs.setRezervacija(r);
//            }
//            db.sacuvajObjekat(rezervacija);
//            db.sacuvajObjekte(listaRezSedista);
//            for (AbstractObjekat ao : karte) {
//                Karta k = (Karta) ao;
//                int id = Kontroler.vratiMaxNoveKarte(k);
//                k.setKartaID(id+1);
//                ao = k;
//                db.sacuvajObjekat(ao);
//            }
            db.sacuvajObjekte(karte);
        } catch (SQLException ex) {
            Logger.getLogger(SOZapamtiKarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
