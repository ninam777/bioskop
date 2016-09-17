/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class KartaZaRezervisanoSediste extends AbstractObjekat{

    private Rezervacija rezervacija;
    private Sediste sediste;
    private Karta karta;

    public KartaZaRezervisanoSediste() {
    }

    public KartaZaRezervisanoSediste(Rezervacija rezervacija, Sediste sediste, Karta karta) {
        this.rezervacija = rezervacija;
        this.sediste = sediste;
        this.karta = karta;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Sediste getSediste() {
        return sediste;
    }

    public void setSediste(Sediste sediste) {
        this.sediste = sediste;
    }

    public Karta getKarta() {
        return karta;
    }

    public void setKarta(Karta karta) {
        this.karta = karta;
    }

    @Override
    public String toString() {
        return "KartaZaRezervisanoSediste{" + "rezervacija=" + rezervacija + ", sediste=" + sediste + ", karta=" + karta + '}';
    }

    @Override
    public String vratiImeTabele() {
        return "kartaZaRezervisanoSediste";
    }

    @Override
    public String vratiParametre() {
        return getRezervacija().getProjekcija().getProjekcijaID() + ", " + getRezervacija().getRezervacijaID() + ", " + getSediste().getSala().getSalaID() + ", " + getSediste().getRed() + ", " + getSediste().getBrojSedista() + ", " + getKarta().getKartaID() + "";
    }

    @Override
    public String vratiPK() {
        return "nema";
    }

    @Override
    public int vratiVrednostPK() {
        return -1;
    }


    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> karteZaRezervisanaSedista = new ArrayList<>();
        try {
            while (rs.next()) {
                int projekcijaID = rs.getInt("projekcijaID");
                int rezervacijaID = rs.getInt("rezervacijaID");
                int salaID = rs.getInt("salaID");
                int red = rs.getInt("red");
                int brojSedista = rs.getInt("brojSedista");
                int kartaID = rs.getInt("kartaID");
                KartaZaRezervisanoSediste kzrs = new KartaZaRezervisanoSediste(new Rezervacija(new Projekcija(projekcijaID, null, null, null, null), rezervacijaID, null, null), new Sediste(new Sala(salaID, null, 0), red, brojSedista), new Karta(new Projekcija(projekcijaID, null, null, null, null), kartaID, 0, null, null));
                karteZaRezervisanaSedista.add(kzrs);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return karteZaRezervisanaSedista;
    }

    @Override
    public String vratiUpdateUpit() {
        return "projekcijaID=" + getRezervacija().getProjekcija().getProjekcijaID()
                + ",rezervacijaID=" + getRezervacija().getRezervacijaID()
                + ",salaID=" + getSediste().getSala().getSalaID()
                + ",red=" + getSediste().getRed()
                + ",brojSedista=" + getSediste().getBrojSedista()
                + ",kartaID=" + getKarta().getKartaID() + "";
    }

    @Override
    public String vratiSlozenPK() {
        return "Nema";
    }

}
