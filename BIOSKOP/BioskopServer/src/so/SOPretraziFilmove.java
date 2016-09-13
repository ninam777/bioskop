/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Radnik;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class SOPretraziFilmove extends AbstractSO{
    
    private List<AbstractObjekat> filmovi;
    private String kriterijumPretrage;
    public SOPretraziFilmove(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }
         
    @Override
    public void izvrsiKonkretnuOperaciju() throws Exception {
        List<AbstractObjekat> all = null;
        try {
            all = db.vratiSveObjekte(new Film());
        } catch (SQLException ex) {
            Logger.getLogger(SOPretraziFilmove.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        filmovi= new LinkedList<>();

        for (AbstractObjekat ao : all) {
            Film f = (Film) ao;
            if (findStringInSearchCriteria(f)) {
                System.out.println("Usao u uslov");
                Radnik r = new Radnik();
                try {
                    r= (Radnik)db.vratiObjekatPoKljucu(new Radnik(), f.getRadnik().getRadnikID());
                } catch (SQLException ex) {
                    Logger.getLogger(SOPretraziFilmove.class.getName()).log(Level.SEVERE, null, ex);
                }
                f.setRadnik(r);
                filmovi.add(f); 
            }
        }
    }

     private boolean findStringInSearchCriteria(Film f) {
        System.out.println(f);
        String[] unosiPretrage = kriterijumPretrage.split(" ");
        for (String unosPretrage : unosiPretrage) {
            if (f.getNazivFilma().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")
                    || f.getReziser().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")
                    || f.getGlumci().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")
                    || f.getZanr().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")
                    || f.getRadnik().getIme().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")) {
                return true;
            }
        }
        return false;
    }

    public List<AbstractObjekat> vratiFilmove() {
        return filmovi;
    }
    
}
