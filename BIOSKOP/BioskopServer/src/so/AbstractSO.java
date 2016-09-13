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

//    public void otvoriBazu() {
//        db.uspostaviKonekcijuMySql();
//        System.out.println("Uspesna konekcija");
//    }
//
//    public void zatvoriBazu() {
//        db.raskiniKonekciju();
//    }
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
//        try {
//            otvoriBazu();
//            izvrsiValidaciju();
//            proveriPreduslove();
//            izvrsiKonkretnuOperaciju();
//            potvrdiTransakciju();
//        } catch (ValidacijaException ve) {
//
//            throw new Exception(ve.getMessage());
//        } catch (PredusloviException pe) {
//            throw new Exception(pe.getMessage());
//        } catch (SOException se) {
//            ponistiTransakciju();
//            throw new Exception(se.getMessage());
//        }
//        zatvoriBazu();
    }

//    protected abstract void izvrsiValidaciju() throws ValidacijaException;
//
//    protected abstract void proveriPreduslove() throws PredusloviException ;
//
    protected abstract void izvrsiKonkretnuOperaciju() throws Exception;
//
//    private void potvrdiTransakciju() {
//        db.commit();
//    }
//
//    private void ponistiTransakciju() {
//        db.rollback();
//    }
}