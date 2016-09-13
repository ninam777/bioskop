/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Sediste;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nina777
 */
public class ModelTabeleRediSedista extends AbstractTableModel {

    ArrayList<Sediste> lista;

    public ModelTabeleRediSedista() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
//        TODO: promeni broj kolona sa brojem kolona u tabeli klijenta
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        TODO: Zameni Object za agregaciju
        Sediste s = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return s.getRed();
            case 1:
                return s.getBrojSedista();

            default:
                return "N/A";
        }

    }
//  TODO: namesti imena kolona
    String[] kolone = {"Red", "Broj sedišta"};

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
        Sediste s = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                s.setRed(Integer.parseInt((String) aValue));
                break;
            case 1:
                s.setBrojSedista(Integer.parseInt((String) aValue));
                break;
        }
    }

//        TODO: Zameni Object za agregaciju
    public ArrayList<Sediste> getLista() {
        return lista;
    }

//        TODO: Zameni Object za agregaciju
    public void setLista(ArrayList<Sediste> lista) {
        this.lista = lista;
    }

    public void dodajRed() {
//        TODO: Zameni Object za agregaciju
        lista.add(new Sediste());
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