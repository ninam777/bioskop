/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author Nina777
 */
public abstract class AbstractSO {

    protected DBBroker db;

    public AbstractSO() {
        db = new DBBroker();
    }

    public void izvrsiOperaciju() throws Exception {
        try {
            db.ucitajDrajver();
            db.otvoriKonekciju();
            izvrsiKonkretnuOperaciju();
            db.komit();
            
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);

            db.rollback();
        }
        db.zatvoriKonekciju();
    }

    protected abstract void izvrsiKonkretnuOperaciju() throws Exception;
}
