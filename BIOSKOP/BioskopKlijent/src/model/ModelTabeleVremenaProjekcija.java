/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Projekcija;
import domen.Sala;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import sesija.Sesija;

/**
 *
 * @author Nina777
 */
public class ModelTabeleVremenaProjekcija extends AbstractTableModel {

    ArrayList<Projekcija> lista;
    ArrayList<Sala> listaSala;

    public ArrayList<Sala> getListaSala() {
        return listaSala;
    }

    public void setListaSala(ArrayList<Sala> listaSala) {
        this.listaSala = listaSala;
    }

    public ModelTabeleVremenaProjekcija() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Projekcija p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getSala();
            case 1:
                if (p.getDatum() == null) {
                    return "";
                }
                return new SimpleDateFormat("dd.MM.yyyy").format(p.getDatum());
            case 2:
                if (p.getVreme() == null) {
                    return "";
                }
                return new SimpleDateFormat("HH:mm:ss").format(p.getVreme());
            default:
                return "N/A";
        }

    }
    String[] kolone = {"Sala", "Datum", "Vreme"};

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
        Projekcija p = lista.get(rowIndex);
        String rezim = (String) Sesija.vratiInstancu().getMapa().get("rezim");
        switch (columnIndex) {
            case 0:
                if (listaSala != null) {
                    for (Sala s : listaSala) {
                        if (s.equals(aValue)) {
                            p.setSala(s);
                        }
                    }
                }
                break;
            case 1:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                Date datum;
                 {
                    try {
                        datum = sdf.parse((String) aValue);
                        p.setDatum(datum);
                    } catch (ParseException ex) {
                        datum = new Date();
                    }
                }
                break;
            case 2:
                sdf = new SimpleDateFormat("HH:mm:ss");
                Date vreme;
                 {
                    try {
                        vreme = sdf.parse((String) aValue);
                        p.setVreme(vreme);
                    } catch (ParseException ex) {
                        vreme = new Date();
                    }
                }
                break;
        }
    }

    public ArrayList<Projekcija> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Projekcija> lista) {
        this.lista = lista;
    }

    public void dodajRed() {
        lista.add(new Projekcija());
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
