/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osvezi;

import forme.FormaRepertoar;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikolinam
 */
public class NitOsvezi extends Thread{
    
    FormaRepertoar fr;

    public NitOsvezi(FormaRepertoar fr) {
        this.fr = fr;
    }
    
    

    @Override
    public void run() {
        while (true) {            
            try {
                fr.srediFormu();
            } catch (IOException ex) {
                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Osvezio");
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitOsvezi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}