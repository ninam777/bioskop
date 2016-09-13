/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Projekcija;
import domen.Sala;
import domen.Sediste;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class SOUcitajListuSedista extends AbstractSO {

    List<AbstractObjekat> sedista;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            sedista = db.vratiSveObjekte(new Sediste());
            List<AbstractObjekat> lista = new ArrayList<>();
            for (AbstractObjekat ao : sedista) {
                Sediste s =  (Sediste) ao;
                s.setSala((Sala) db.vratiObjekatPoKljucu(new Sala(), s.getSala().getSalaID()));
                lista.add(s);
            }
            sedista = lista;
        } catch (SQLException ex) {
            System.out.println("Nisu vracene projekcije.");
        }
    }

    public List<AbstractObjekat> vratiSedista() {
        return sedista;
    }

}
