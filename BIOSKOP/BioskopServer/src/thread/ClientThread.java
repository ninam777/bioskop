/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import com.sun.corba.se.spi.activation.Server;
import domen.AbstractObjekat;
import domen.Film;
import domen.Radnik;
import domen.Rezervacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpringLayout;
import konstante.Konstante;

import kontroler.Kontroler;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Nina777
 */
public class ClientThread extends Thread {

    Socket s;
    List<ClientThread> klijenti;

    public ClientThread(Socket s, List<ClientThread> klijenti) {
        this.s = s;
        this.klijenti = klijenti;

    }

    @Override
    public void run() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            while (true) {
                KlijentskiTransferObjekat kt = (KlijentskiTransferObjekat) in.readObject();
                int operacija = kt.getOperacija();
                if (operacija == konstante.Konstante.OPERACIJA_VRATI_PROJEKCIJE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {

                        List<AbstractObjekat> lao = Kontroler.ucitajProjekcije();
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == konstante.Konstante.OPERACIJA_VRATI_RADNIKE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {

                        List<AbstractObjekat> lao = Kontroler.ucitajRadnike();
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == konstante.Konstante.OPERACIJA_VRATI_SEDISTA) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {

                        List<AbstractObjekat> lao = Kontroler.ucitajSedista();
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == konstante.Konstante.OPERACIJA_VRATI_REZ_SEDISTA) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {

                        List<AbstractObjekat> lao = Kontroler.ucitajRezervisanaSedista();
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (operacija == Konstante.OPERACIJA_VRATI_FILM) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        int id = (int) kt.getParametar();

                        AbstractObjekat kl = Kontroler.ucitajFilm(id);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(kl);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (operacija == Konstante.OPERACIJA_VRATI_REZERVACIJU) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        int id = (int) kt.getParametar();

                        AbstractObjekat kl = Kontroler.ucitajRezervaciju(id);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(kl);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (operacija == Konstante.OPERACIJA_NADJI_RADNIKA) {

                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        AbstractObjekat r = kontroler.Kontroler.nadjiRadnika((Radnik) kt.getParametar());
                        if (r != null) {
                            st.setUspesnostIzvrsenjaOperacije(1);
                            st.setPodaci(r);
                        } else {
                            st.setUspesnostIzvrsenjaOperacije(-1);
                        }
                    } catch (Exception ex) {

                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (operacija == Konstante.OPERACIJA_SACUVAJ_IZMENI_FILM) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        List<AbstractObjekat> lao =  (List<AbstractObjekat>) kt.getParametar();

                        Kontroler.zapamtiFilm(lao);
                        st.setUspesnostIzvrsenjaOperacije(1);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == Konstante.OPERACIJA_SACUVAJ_REZERVACIJU) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        List<AbstractObjekat> lao =  (List<AbstractObjekat>) kt.getParametar();

                        Kontroler.zapamtiRezervaciju(lao);
                        st.setUspesnostIzvrsenjaOperacije(1);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (operacija == Konstante.OPERACIJA_SACUVAJ_KARTE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        List<AbstractObjekat> karte = (List<AbstractObjekat>) kt.getParametar();
                        Kontroler.zapamtiKarte(karte);
                        st.setUspesnostIzvrsenjaOperacije(1);

                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (operacija == Konstante.OPERACIJA_SACUVAJ_KARTE_ZA_REZ_SED) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        List<AbstractObjekat> karte = (List<AbstractObjekat>) kt.getParametar();
                        Kontroler.zapamtiKarteZaRezervisanoSediste(karte);
                        st.setUspesnostIzvrsenjaOperacije(1);

                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (operacija == Konstante.OPERACIJA_OBRISI_FILM) {

                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        AbstractObjekat f = (AbstractObjekat) kt.getParametar();

                        kontroler.Kontroler.obrisiFilm(f);
                        st.setUspesnostIzvrsenjaOperacije(1);

                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == Konstante.OPERACIJA_OBRISI_REZERVACIJU) {

                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                    try {
                        AbstractObjekat rez = (AbstractObjekat) kt.getParametar();

                        kontroler.Kontroler.obrisiRezervaciju(rez);
                        st.setUspesnostIzvrsenjaOperacije(1);

                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == Konstante.OPERACIJA_PRETRAZI_FILMOVE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                   try {
                        String kriterijumi = (String) kt.getParametar();
                        List<AbstractObjekat> lao = Kontroler.pretraziFilmove(kriterijumi);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                        
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }

                if (operacija == Konstante.OPERACIJA_PRETRAZI_REZERVACIJE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                   try {
                        String kriterijumi = (String) kt.getParametar();
                        List<AbstractObjekat> lao = Kontroler.pretraziRezervacije(kriterijumi);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(lao);
                        
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                
                if (operacija == Konstante.OPERACIJA_KREIRAJ_NOVI_FILM) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                   try {
                        AbstractObjekat ao = new Film();
                        int film = Kontroler.vratiMaxFilm(ao);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(film);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == Konstante.OPERACIJA_KREIRAJ_NOVU_REZERVACIJU) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                   try {
                        AbstractObjekat ao = new Rezervacija();
                        int rez = Kontroler.vratiMaxRezervacija(ao);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(rez);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
                if (operacija == Konstante.OPERACIJA_KREIRAJ_NOVE_KARTE) {
                    ServerskiTransferObjekat st = new ServerskiTransferObjekat();
                   try {
                        AbstractObjekat ao = new Rezervacija();
                        int karta = Kontroler.vratiMaxNoveKarte(ao);
                        st.setUspesnostIzvrsenjaOperacije(1);
                        st.setPodaci(karta);
                    } catch (Exception ex) {
                        st.setUspesnostIzvrsenjaOperacije(-1);
                        st.setException(ex);
                    }
                    out.writeObject(st);
                }
            }
        } catch (IOException ex) {
            System.out.println("Klijent se otkacio");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                System.out.println("zatvoren socket");
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
