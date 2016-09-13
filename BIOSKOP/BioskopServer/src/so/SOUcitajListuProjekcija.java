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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class SOUcitajListuProjekcija extends AbstractSO {

    List<AbstractObjekat> projekcije;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws Exception {
        try {
            projekcije = db.vratiSveObjekte(new Projekcija());
            List<AbstractObjekat> lista = new ArrayList<>();
            for (AbstractObjekat ao : projekcije) {
                Projekcija p = (Projekcija) ao;
                p.setFilm((Film) db.vratiObjekatPoKljucu(new Film(), p.getFilm().getFilmID()));
                p.setSala((Sala) db.vratiObjekatPoKljucu(new Sala(), p.getSala().getSalaID()));
                lista.add(p);
            }
            projekcije = lista;
        } catch (SQLException ex) {
            System.out.println("Nisu vracene projekcije.");
        }
    }

    public List<AbstractObjekat> vratiProjekcije() {
        return projekcije;
    }

}
