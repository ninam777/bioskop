/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObjekat;
import domen.Film;
import domen.Karta;
import domen.Projekcija;
import domen.Radnik;
import domen.Rezervacija;
import domen.RezervisanoSediste;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Konstante;

import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Nina777
 */
public class Kontroler {

    public Kontroler() {
    }

    public boolean sacuvajFilm(Film f, List<Projekcija> lp) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        List<AbstractObjekat> lista = new LinkedList<>();
        lista.add(f);
        for (AbstractObjekat ao : lp) {
            lista.add(ao);
        }
        kt.setOperacija(Konstante.OPERACIJA_SACUVAJ_IZMENI_FILM);
        kt.setParametar(lista);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sacuvajKarte(List<Karta> karte) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_SACUVAJ_KARTE);
        kt.setParametar(karte);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sacuvajRezervaciju(Rezervacija r, List<RezervisanoSediste> lrs) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        List<AbstractObjekat> lista = new LinkedList<>();
        lista.add(r);
        for (AbstractObjekat ao : lrs) {
            lista.add(ao);
        }
        kt.setOperacija(Konstante.OPERACIJA_SACUVAJ_REZERVACIJU);
        kt.setParametar(lista);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<AbstractObjekat> vratiListuProjekcija() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_VRATI_PROJEKCIJE);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();

        } else {
            return null;
        }
    }

    public List<AbstractObjekat> vratiListuRadnika() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_VRATI_RADNIKE);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();

        } else {
            return null;
        }
    }

    public List<AbstractObjekat> vratiListuSedista() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_VRATI_SEDISTA);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();

        } else {
            return null;
        }
    }

    public Film vratiFilm(int id) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_VRATI_FILM);
        kt.setParametar(id);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (Film) st.getPodaci();
        } else {
            return null;
        }
    }

    public Rezervacija vratiRezervaciju(String id) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_VRATI_REZERVACIJU);
        kt.setParametar(id);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (Rezervacija) st.getPodaci();
        } else {
            return null;
        }
    }

    public Radnik prijaviKorisnika(Radnik r) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_NADJI_RADNIKA);
        kt.setParametar(r);
        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            System.out.println(((Radnik) st.getPodaci()).getRadnikID());
            return (Radnik) st.getPodaci();
        } else {
            return null;
        }
    }

    public boolean obrisiFilm(Film f) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_OBRISI_FILM);
        kt.setParametar(f);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return true;
        }
        return false;
    }

    public boolean obrisiRezervaciju(Rezervacija r) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_OBRISI_REZERVACIJU);
        kt.setParametar(r);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return true;
        }
        return false;
    }

    public List<AbstractObjekat> pretraziFilmove(String kriterijumi) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_PRETRAZI_FILMOVE);
        kt.setParametar(kriterijumi);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();

        } else {
            return null;
        }
    }

    public List<AbstractObjekat> pretraziRezervacije(String kriterijumi) throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_PRETRAZI_REZERVACIJE);
        kt.setParametar(kriterijumi);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (List<AbstractObjekat>) st.getPodaci();

        } else {
            return null;
        }
    }

    public int kreirajNoviFilm() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_KREIRAJ_NOVI_FILM);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (int) st.getPodaci();
        }
        return -1;
    }

    public int kreirajNovuRezervaciju() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_KREIRAJ_NOVU_REZERVACIJU);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (int) st.getPodaci();
        }
        return -1;
    }

    public int kreirajNoveKarte() throws IOException, ClassNotFoundException {
        KlijentskiTransferObjekat kt = new KlijentskiTransferObjekat();
        kt.setOperacija(Konstante.OPERACIJA_KREIRAJ_NOVE_KARTE);

        Komunikacija.vratiInstancu().posaljiZahtev(kt);
        ServerskiTransferObjekat st = Komunikacija.vratiInstancu().procitajOdgovor();
        if (st.getUspesnostIzvrsenjaOperacije() == 1) {
            return (int) st.getPodaci();
        }
        return -1;
    }

}
