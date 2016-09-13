/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package start;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import thread.ClientThread;

/**
 *
 * @author Nina777
 */
public class SocketServer extends Thread {

    private ServerSocket ss;
    private int brojPorta;
    public static List<ClientThread> klijenti = new ArrayList<>() ;

    public SocketServer(int brPorta) {
        this.brojPorta = brPorta;
        try {
            ss = new ServerSocket(brPorta);
            System.out.println("Kreiran server socket");

        } catch (IOException ex) {
            System.out.println("Neuspesno kreiranje serveskog soketa");
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket s = ss.accept();


                ClientThread k = new ClientThread(s,klijenti);
                int i = klijenti.size()+1;
                k.start();
                klijenti.add(k);
                System.out.println("Klijent broj "+i+" se povezao");

            } catch (IOException ex) {
                System.out.println("Nije moguce prihvatiti klijenta");
            }

        }
    }
}
