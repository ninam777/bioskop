/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nina777
 */
public class RezervisanoSediste extends AbstractObjekat{
    private Rezervacija rezervacija;
    private Sediste sediste;
    private int trajanjeRezervacije;

    public RezervisanoSediste() {
    }

    public RezervisanoSediste(Rezervacija rezervacija, Sediste sediste, int trajanjeRezervacije) {
        this.rezervacija = rezervacija;
        this.sediste = sediste;
        this.trajanjeRezervacije = trajanjeRezervacije;
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

    public int getTrajanjeRezervacije() {
        return trajanjeRezervacije;
    }

    public void setTrajanjeRezervacije(int trajanjeRezervacije) {
        this.trajanjeRezervacije = trajanjeRezervacije;
    }

    @Override
    public String toString() {
        return "RezervisanoSediste{" + "rezervacija=" + rezervacija + ", sediste=" + sediste + ", trajanjeRezervacije=" + trajanjeRezervacije + '}';
    }
    
    @Override
    public String vratiImeTabele() {
        return "rezervisanoSediste";
    }

    @Override
    public String vratiParametre() {
        return getRezervacija().getRezervacijaID() + ", " + getSediste().getSala().getSalaID() + ", " + getSediste().getRed() + ", " + getSediste().getBrojSedista() + ", " + trajanjeRezervacije + "" ;
    }

    @Override
    public String vratiPK() {
        return "nema";
    }

    @Override
    public int vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRSuTabelu(ResultSet rs) {
        List<AbstractObjekat> rezervisanaSedista = new ArrayList<>();
        try {
            while (rs.next()) {
                int projekcijaID = rs.getInt("projekcijaID");
                int rezervacijaID = rs.getInt("rezervacijaID");
                int salaID = rs.getInt("salaID");
                int red = rs.getInt("red");
                int brojSedista = rs.getInt("brojSedista");
                int trajanjeRezervacije = rs.getInt("trajanjeRezervacije");
                RezervisanoSediste rezSed = new RezervisanoSediste(new Rezervacija(new Projekcija(projekcijaID, null, null, null, null), rezervacijaID, null, null), new Sediste(new Sala(salaID, null, 0), red, brojSedista), trajanjeRezervacije);
                rezervisanaSedista.add(rezSed);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return rezervisanaSedista;
    }

    @Override
    public String vratiUpdateUpit() {
        return "projekcijaID=" + getRezervacija().getProjekcija().getProjekcijaID()
                + ",rezervacijaID=" + getRezervacija().getRezervacijaID()
                + ",salaID=" + getSediste().getSala().getSalaID()
                + ",red=" + getSediste().getRed()
                + ",brojSedista=" + getSediste().getBrojSedista()
                + ",trajanjeRezervacije=" + trajanjeRezervacije + "";
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE projekcijaID= " + getRezervacija().getProjekcija().getProjekcijaID() + " AND rezervacijaID=" + getRezervacija().getRezervacijaID() + " AND salaID=" + getSediste().getSala().getSalaID() + " AND red=" + getSediste().getRed() + " AND brojSedista=" + getSediste().getBrojSedista() + "";
    }

   
}
