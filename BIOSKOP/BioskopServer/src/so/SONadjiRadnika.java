/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Radnik;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class SONadjiRadnika extends AbstractSO {

    AbstractObjekat radnik;
    AbstractObjekat ulogovani;

    public SONadjiRadnika(AbstractObjekat radnik) {
        this.radnik = radnik;
        ulogovani = null;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            List<AbstractObjekat> radnici = db.vratiSveObjekte(radnik);
            Radnik uneti = (Radnik) radnik;
            for (AbstractObjekat rad : radnici) {
                Radnik r = (Radnik) rad;
                if (r.getKorisnickoIme().equals(uneti.getKorisnickoIme()) && r.getKorisnickaSifra().equals(uneti.getKorisnickaSifra())) {
                    this.ulogovani = r;
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SONadjiRadnika.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AbstractObjekat vratiRadnika() {
        return ulogovani;
    }
}
