/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Rezervacija;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nina777
 */
public class ModelTabeleRezervacija extends AbstractTableModel {
    ArrayList<Rezervacija> lista;

    public ModelTabeleRezervacija() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija r = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return r.getNazivRezervacije();
            case 1:
                return r.getProjekcija().getFilm().getNazivFilma();
            case 2:
                if (r.getProjekcija().getDatum() == null) {
                    return "";
                }
                return new SimpleDateFormat("dd.MM.yyyy").format(r.getProjekcija().getDatum());
            case 3:
                if (r.getProjekcija().getVreme() == null) {
                    return "";
                }
                return new SimpleDateFormat("HH:mm:ss").format(r.getProjekcija().getVreme());
            case 4:
                return r.getProjekcija().getSala().getNazivSale();
            default:
                return "N/A";
        }

    }

    String[] kolone = {"Naziv rezervacije", "Film", "Datum prikazivanja", "Vreme prikazivanja", "Sala"};

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        if (columnIndex == 0) {
//            return false;
//        }
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Rezervacija r = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                r.setNazivRezervacije((String) aValue);
                break;
            case 1:
                r.getProjekcija().getFilm().setNazivFilma((String) aValue);
                break;
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date datum;
                 {
                    try {
                        datum = sdf.parse((String) aValue);
                        r.getProjekcija().setDatum(datum);
                    } catch (ParseException ex) {
                        datum = new Date();
                    }
                }
                break;
            case 3:
                sdf = new SimpleDateFormat("HH:mm:ss");
                Date vreme;
                 {
                    try {
                        vreme = sdf.parse((String) aValue);
                        r.getProjekcija().setVreme(vreme);
                    } catch (ParseException ex) {
                        vreme = new Date();
                    }
                }
                break;
            case 4:
                r.getProjekcija().getSala().setNazivSale((String) aValue);
                break;
        }
    }

    public ArrayList<Rezervacija> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Rezervacija> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void dodajRed() {
        lista.add(new Rezervacija());
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public void skloniPodatke() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }
}
