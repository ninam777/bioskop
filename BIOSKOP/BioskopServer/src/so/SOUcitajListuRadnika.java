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

/**
 *
 * @author Nina777
 */
public class SOUcitajListuRadnika extends AbstractSO {

    List<AbstractObjekat> radnici;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            radnici = db.vratiSveObjekte(new Radnik());
        } catch (SQLException ex) {
            System.out.println("Nisu vracene projekcije.");
        }
    }

    public List<AbstractObjekat> vratiRadnike() {
        return radnici;
    }

}
