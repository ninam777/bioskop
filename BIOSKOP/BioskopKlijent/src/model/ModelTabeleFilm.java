/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Film;
import domen.Projekcija;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nina777
 */
public class ModelTabeleFilm extends AbstractTableModel {

    ArrayList<Film> lista;
    ArrayList<Projekcija> listaProjekcija;

    public ModelTabeleFilm() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film f = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getFilmID();
            case 1:
                return f.getNazivFilma();
            case 2:
                return f.getZanr();
            case 3:
                return f.getTrajanje();
            case 4:
                return f.getReziser();
            case 5:
                return f.getGlumci();
            case 6:
                return f.getOpis();

            default:
                return "N/A";
        }

    }
//  TODO: namesti imena kolona
    String[] kolone = {"ID filma","Naziv filma", "Žanr", "Trajanje", "Režiser", "Glumci", "Opis"};

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        TODO: ukoliko zelimo da zabranimo promenu neke kolone ili polja u tabeli
//        if (columnIndex == 0) {
//            return false;
//        }

        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //        TODO: Zameni Object za agregaciju
        Film f = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                f.setFilmID(Integer.parseInt((String) aValue));
                break;
            case 1:
                f.setNazivFilma((String) aValue);
                break;
            case 2:
                f.setZanr((String) aValue);
                break;
            case 3:
                f.setTrajanje(Integer.parseInt((String) aValue));
                break;
            case 4:
                f.setReziser((String) aValue);
                break;
            case 5:
                f.setGlumci((String) aValue);
                break;
            case 6:
                f.setOpis((String) aValue);
                break;

        }
    }

//        TODO: Zameni Object za agregaciju
    public ArrayList<Film> getLista() {
        return lista;
    }

//        TODO: Zameni Object za agregaciju
    public void setLista(ArrayList<Film> lista) {
        this.lista = lista;
    }

    public void dodajRed() {
//        TODO: Zameni Object za agregaciju
        lista.add(new Film());
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
