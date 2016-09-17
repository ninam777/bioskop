/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObjekat;
import domen.Film;
import domen.Projekcija;
import domen.Radnik;
import domen.Rezervacija;
import domen.Sala;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class SOPretraziRezervacije extends AbstractSO {

    private List<AbstractObjekat> rezervacije;
    private String kriterijumPretrage;

    public SOPretraziRezervacije(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    @Override
    public void izvrsiKonkretnuOperaciju() throws Exception {
        List<AbstractObjekat> all = null;
        try {
            all = db.vratiSveObjekte(new Rezervacija());
        } catch (SQLException ex) {
            Logger.getLogger(SOPretraziRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }

        rezervacije = new LinkedList<>();

        for (AbstractObjekat ao : all) {
            Rezervacija rez = (Rezervacija) ao;
            Projekcija p = new Projekcija();
            Radnik r = new Radnik();
            Film f = new Film();
            Sala s = new Sala();
            try {
                p = (Projekcija) db.vratiObjekatPoKljucu(new Projekcija(), rez.getProjekcija().getProjekcijaID());
                r = (Radnik) db.vratiObjekatPoKljucu(new Radnik(), rez.getRadnik().getRadnikID());
                f = (Film) db.vratiObjekatPoKljucu(new Film(), p.getFilm().getFilmID());
                s = (Sala) db.vratiObjekatPoKljucu(new Sala(), p.getSala().getSalaID());
            } catch (SQLException ex) {
                Logger.getLogger(SOPretraziRezervacije.class.getName()).log(Level.SEVERE, null, ex);
            }
            rez.setProjekcija(p);
            rez.setRadnik(r);
            rez.getProjekcija().setFilm(f);
            rez.getProjekcija().setSala(s);
            if (findStringInSearchCriteria(rez)) {
                rezervacije.add(rez);
            }
        }
    }

    private boolean findStringInSearchCriteria(Rezervacija rez) {
        String[] unosiPretrage = kriterijumPretrage.split(" ");
        for (String unosPretrage : unosiPretrage) {
            if (rez.getNazivRezervacije().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")
                    || rez.getProjekcija().getFilm().getNazivFilma().toLowerCase().matches("(.*)" + unosPretrage.toLowerCase() + "(.*)")) {
                return true;
            }
        }
        return false;
    }

    public List<AbstractObjekat> vratiRezervacije() {
        return rezervacije;
    }

}
