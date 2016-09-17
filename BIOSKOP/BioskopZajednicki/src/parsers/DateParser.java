/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nina777
 */
public class DateParser {
    public static Date parse (String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date d = new Date();
        try {
            d = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return d;
    }
    
    public static Date izSqlDatumaString (String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date d = new Date();
        try {
            d = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return d;
    }
    
    public static Date izSqlVremenaString (String date){
        SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss");
        Date d = new Date();
        try {
            d = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(DateParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return d;
    }
    
    public static String izSqlDatuma (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(date);
    }
    
    public static String izSqlVremena (Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss");
        return sdf.format(date);        
    }
    public static java.sql.Date getSqlDate(Date utilDate){
        java.sql.Date sql = new java.sql.Date(utilDate.getTime());
        return sql;
    }  
    public static String getUtilFromUtil(Date d){
         SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         return sdf.format(d);
    }
}
