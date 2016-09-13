/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.Glavna;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author Nina777
 */
public class KlijentStart extends Thread{

    @Override
    public void run() {
        try {
            Socket socket = new Socket("localhost", 9000);
            Komunikacija.vratiInstancu().setSocket(socket);
        } catch (IOException ex) {
            Logger.getLogger(KlijentStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
            new Glavna().setVisible(true);
    }

}
