/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Nina777
 */
public class ServerskiTransferObjekat implements Serializable{
    private Object podaci;
    private int uspesnostIzvrsenjaOperacije;
    private Exception exception;

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesnostIzvrsenjaOperacije() {
        return uspesnostIzvrsenjaOperacije;
    }

    public void setUspesnostIzvrsenjaOperacije(int uspesnostIzvrsenjaOperacije) {
        this.uspesnostIzvrsenjaOperacije = uspesnostIzvrsenjaOperacije;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}

