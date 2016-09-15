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
import sun.print.resources.serviceui;

/**
 *
 * @author Nina777
 */
public class Sediste extends AbstractObjekat {

    private Sala sala;
    private int red;
    private int brojSedista;
    private boolean rezervisano;
    private boolean kupljeno;

    public Sediste() {
    }

    public Sediste(Sala sala, int red, int brojSedista, boolean rezervisano, boolean kupljeno) {
        this.sala = sala;
        this.red = red;
        this.brojSedista = brojSedista;
        this.rezervisano = rezervisano;
        this.kupljeno = kupljeno;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBrojSedista() {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista) {
        this.brojSedista = brojSedista;
    }

    public boolean isRezervisano() {
        return rezervisano;
    }

    public void setRezervisano(boolean rezervisano) {
        this.rezervisano = rezervisano;
    }

    public boolean isKupljeno() {
        return kupljeno;
    }

    public void setKupljeno(boolean kupljeno) {
        this.kupljeno = kupljeno;
    }

    @Override
    public String toString() {
        return "Sediste{" + "sala=" + sala + ", red=" + red + ", brojSedista=" + brojSedista + ", rezervisano=" + rezervisano + ", kupljeno=" + kupljeno + '}';
    }

    @Override
    public String vratiImeTabele() {
        return "sediste";
    }

    @Override
    public String vratiParametre() {
        return getSala().getSalaID() + ", " + red + ", " + brojSedista + ", " + rezervisano + ", " + kupljeno + "";
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
        List<AbstractObjekat> sedista = new ArrayList<>();
        try {
            while (rs.next()) {
                int salaID = rs.getInt("salaID");
                int red = rs.getInt("red");
                int brojSedista = rs.getInt("brojSedista");
                boolean reze = rs.getBoolean("rezervisano");
                boolean kup = rs.getBoolean("kupljeno");
                Sediste s = new Sediste(new Sala(salaID, null, 0), red, brojSedista, reze, kup);
                sedista.add(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod klijenata.");
        }
        return sedista;
    }

    @Override
    public String vratiUpdateUpit() {
        return "salaID=" + getSala().getSalaID()
                + ",red=" + red
                + ",brojSedista=" + brojSedista 
                + ",rezervisano=" + rezervisano
                + ",kupljeno=" + kupljeno + "";
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE salaID= " + getSala().getSalaID() + " AND red=" + getRed() + " AND brojSedista=" + getBrojSedista();
    }

}
