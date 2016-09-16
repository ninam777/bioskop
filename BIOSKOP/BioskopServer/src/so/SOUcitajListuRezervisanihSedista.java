/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Rezervacija;
import domen.RezervisanoSediste;
import domen.Sala;
import domen.Sediste;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nikolinam
 */
public class SOUcitajListuRezervisanihSedista extends AbstractSO {

    List<AbstractObjekat> sedista;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
//            radnici = db.vratiSveObjekte(new Projekcija());
            
            sedista = db.vratiSveObjekte(new RezervisanoSediste());
//          
        } catch (SQLException ex) {
            System.out.println("Nisu vracene projekcije.");
        }
    }

    public List<AbstractObjekat> vratiRezervisanaSedista() {
        return sedista;
    }

}
