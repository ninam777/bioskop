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
public class Sediste extends AbstractObjekat {

    private Sala sala;
    private int red;
    private int brojSedista;

    public Sediste() {
    }

    public Sediste(Sala sala, int red, int brojSedista) {
        this.sala = sala;
        this.red = red;
        this.brojSedista = brojSedista;
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

    @Override
    public String toString() {
        return "Sediste{" + "sala=" + sala + ", red=" + red + ", brojSedista=" + brojSedista + '}';
    }

    @Override
    public String vratiImeTabele() {
        return "sediste";
    }

    @Override
    public String vratiParametre() {
        return getSala().getSalaID() + ", " + red + ", " + brojSedista + "";
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
        List<AbstractObjekat> sedista = new ArrayList<>();
        try {
            while (rs.next()) {
                int salaID = rs.getInt("salaID");
                int red = rs.getInt("red");
                int brojSedista = rs.getInt("brojSedista");
                Sediste s = new Sediste(new Sala(salaID, null, 0), red, brojSedista);
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
                + ",brojSedista=" + brojSedista + "";
    }

    @Override
    public String vratiSlozenPK() {
        return " WHERE salaID= " + getSala().getSalaID() + " AND red=" + getRed() + " AND brojSedista=" + getBrojSedista();
    }
}
