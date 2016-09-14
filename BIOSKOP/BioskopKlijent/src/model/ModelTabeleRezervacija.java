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
//    TODO: lista onoga sto su polja u tabeli, agregacija u modelu
//    ArrayList<Angazovanje> listaAngazovanja;
    //        TODO: Zameni Object za agregaciju

    ArrayList<Rezervacija> lista;

    //ukoliko treba da se popuni neki objekat na osnovu samo odredjenog atributa, bice potreba lista kao npr listaKnjiga
//    ArrayList<Knjiga> listaKnjiga;
//    String nazivProjekta = "";
//    public String getNazivProjekta() {
//        return nazivProjekta;
//    }
//
//    public void setNazivProjekta(String nazivProjekta) {
//        this.nazivProjekta = nazivProjekta;
//    }
    public ModelTabeleRezervacija() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
//        TODO: promeni broj kolona sa brojem kolona u tabeli klijenta
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        TODO: Zameni Object za agregaciju
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
                return new SimpleDateFormat("hh:mm:ss").format(r.getProjekcija().getVreme());
            case 4:
                return r.getProjekcija().getSala().getNazivSale();
//            TODO: namesti kolone
//            case 0:
//                return nazivProjekta;
//            case 1:
//                return ang.getInzenjer();
//            case 2:
//
//                if (ang.getDatumAngazovanja() == null) {
//                    return "";
//                }
//                return new SimpleDateFormat("dd.MM.yyyy").format(ang.getDatumAngazovanja());

            default:
                return "N/A";
        }

    }
//  TODO: namesti imena kolona
    String[] kolone = {"Naziv rezervacije", "Film", "Datum prikazivanja", "Vreme prikazivanja", "Sala"};

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
                sdf = new SimpleDateFormat("hh:mm:ss");
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
//            TODO: podesi kolone
//            case 0:
//                ang.setProjekat((Projekat) aValue);
//                break;
//            case 1:
//                ang.setInzenjer((Inzenjer) aValue);
//                break;
//            case 2:
//
//                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//                Date datum;
//
//                 {
//                    try {
//                        datum = sdf.parse((String) aValue);
//                        ang.setDatumAngazovanja(datum);
//                    } catch (ParseException ex) {
//                        datum = new Date();
//                    }
//
//                    break;
//                }

            // ukoliko je potrebno popuniti objekat na osnovu nekog atributa, radi se na sledeci nacin
//            case 1:
//                sr.setRb(rowIndex+1);
//                for (Knjiga k : listaKnjiga) {
//                    if (k.getNaziv().equals(aValue)){
//                        sr.setKnjiga(k);
//                    }
//                }
//                sr.getKnjiga().setNaziv((String) aValue);
//                sr.getKnjiga().setAutor(sr.getKnjiga().getAutor());
//                sr.getKnjiga().setCena(sr.getKnjiga().getCena());
//                break;
        }
    }

//        TODO: Zameni Object za agregaciju
    public ArrayList<Rezervacija> getLista() {
        return lista;
    }

//        TODO: Zameni Object za agregaciju
    public void setLista(ArrayList<Rezervacija> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void dodajRed() {
//        TODO: Zameni Object za agregaciju
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
