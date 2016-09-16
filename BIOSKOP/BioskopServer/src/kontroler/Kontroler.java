/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Radnik;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.SOKreirajNoveKarte;
import so.SOKreirajNoviFilm;
import so.SOKreirajNovuRezervaciju;
import so.SONadjiRadnika;
import so.SOObrisiFilm;
import so.SOObrisiRezervaciju;
import so.SOPretraziFilmove;
import so.SOPretraziRezervacije;
import so.SOUcitajFilm;
import so.SOUcitajListuProjekcija;
import so.SOUcitajListuRadnika;
import so.SOUcitajListuRezervisanihSedista;
import so.SOUcitajListuSedista;
import so.SOUcitajRezervaciju;
import so.SOZapamtiFilm;
import so.SOZapamtiKarte;
import so.SOZapamtiKarteZaRezervisanoSediste;
import so.SOZapamtiRezervaciju;

public class Kontroler {

    public static AbstractObjekat nadjiRadnika(AbstractObjekat podaci) throws Exception {
        SONadjiRadnika so = new SONadjiRadnika((Radnik) podaci);
        so.izvrsiOperaciju();
        return so.vratiRadnika();
    }

    public static int vratiMaxNoveKarte(AbstractObjekat ao) {
        SOKreirajNoveKarte so = new SOKreirajNoveKarte(ao);
        try {
            so.izvrsiOperaciju();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getId();
    }

    public static int vratiMaxFilm(AbstractObjekat ao) {
        SOKreirajNoviFilm so = new SOKreirajNoviFilm(ao);
        try {
            so.izvrsiOperaciju();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getId();
    }

    public static int vratiMaxRezervacija(AbstractObjekat ao) {
        SOKreirajNovuRezervaciju so = new SOKreirajNovuRezervaciju(ao);
        try {
            so.izvrsiOperaciju();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getId();
    }

    public static void obrisiFilm(AbstractObjekat f) throws Exception {
        SOObrisiFilm so = new SOObrisiFilm(f);
        so.izvrsiOperaciju();
    }

    public static void obrisiRezervaciju(AbstractObjekat r) throws Exception {
        SOObrisiRezervaciju so = new SOObrisiRezervaciju(r);
        so.izvrsiOperaciju();
    }

    public static List<AbstractObjekat> pretraziFilmove(String kriterijum) throws Exception {
        SOPretraziFilmove so = new SOPretraziFilmove(kriterijum);
        so.izvrsiOperaciju();
        return so.vratiFilmove();
    }

    public static List<AbstractObjekat> pretraziRezervacije(String kriterijum) throws Exception {
        SOPretraziRezervacije so = new SOPretraziRezervacije(kriterijum);
        so.izvrsiOperaciju();
        return so.vratiRezervacije();
    }

    public static AbstractObjekat ucitajFilm(int idFilma) throws Exception {
        SOUcitajFilm so = new SOUcitajFilm(idFilma);
        so.izvrsiOperaciju();
        return so.vratiFilm();
    }

    public static AbstractObjekat ucitajRezervaciju(int idRez) throws Exception {
        SOUcitajRezervaciju so = new SOUcitajRezervaciju(idRez);
        so.izvrsiOperaciju();
        return so.vratiRezervaciju();
    }

    public static List<AbstractObjekat> ucitajProjekcije() throws Exception {
        SOUcitajListuProjekcija so = new SOUcitajListuProjekcija();
        so.izvrsiOperaciju();
        return so.vratiProjekcije();
    }

    public static List<AbstractObjekat> ucitajRadnike() throws Exception {
        SOUcitajListuRadnika so = new SOUcitajListuRadnika();
        so.izvrsiOperaciju();
        return so.vratiRadnike();
    }

    public static List<AbstractObjekat> ucitajSedista() throws Exception {
        SOUcitajListuSedista so = new SOUcitajListuSedista();
        so.izvrsiOperaciju();
        return so.vratiSedista();
    }
    
    public static List<AbstractObjekat> ucitajRezervisanaSedista() throws Exception {
        SOUcitajListuRezervisanihSedista so = new SOUcitajListuRezervisanihSedista();
        so.izvrsiOperaciju();
        return so.vratiRezervisanaSedista();
    }

    public static void zapamtiFilm(List<AbstractObjekat> lista) throws Exception {
        AbstractObjekat f = lista.get(0);
        List<AbstractObjekat> lr = new LinkedList<>();
        for (int i = 1; i < lista.size(); i++) {
            lr.add(lista.get(i));
        }
        SOZapamtiFilm so = new SOZapamtiFilm(f, lr);
        so.izvrsiOperaciju();
    }

    public static void zapamtiKarte(List<AbstractObjekat> k) throws Exception {
        SOZapamtiKarte so = new SOZapamtiKarte(k);
        so.izvrsiOperaciju();
    }
    
    public static void zapamtiKarteZaRezervisanoSediste(List<AbstractObjekat> k) throws Exception {
        SOZapamtiKarteZaRezervisanoSediste so = new SOZapamtiKarteZaRezervisanoSediste(k);
        so.izvrsiOperaciju();
    }

    public static void zapamtiRezervaciju(List<AbstractObjekat> lista) throws Exception {
        AbstractObjekat rez = lista.get(0);
        List<AbstractObjekat> lsr = new LinkedList<>();
        for (int i = 1; i < lista.size(); i++) {
            lsr.add(lista.get(i));
        }
        SOZapamtiRezervaciju so = new SOZapamtiRezervaciju(rez, lsr);
        so.izvrsiOperaciju();
    }

}
