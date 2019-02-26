
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Princess Joy Padua
 * 
 */
public class DatiCondivisi {
    /**
     * @author Princess Joy Padua 
     * 
     * Creo variabili di tipo int che mi vanno a contare i suoni effettuati dai thread.
     * 
     */
    int contaDIN=0,contaDON=0,contaDAN=0;
    
    int maxElem=10000000;
    String schermo[];
    int p;
 
      private Semaphore sDin;
    private Semaphore sDon;
    private Semaphore sDan;
    
    public DatiCondivisi() {
        this.schermo=new String [maxElem];
        this.p=0;
        
        sDin = new Semaphore(0);
        sDon = new Semaphore(0);
        sDan = new Semaphore(0);
    }
public void waitSDin() throws InterruptedException {
        sDin.acquire();
    }
    public void signalSDin() {
        sDin.release();
    }
    public void waitSDon() throws InterruptedException {
        sDon.acquire();
    }
    public void signalSDon() {
        sDon.release();
    }
    public void waitSDan() throws InterruptedException {
        sDan.acquire();
    }
    public void signalSDan() {
        sDan.release();
    }
    

    public int getContaDIN() {
        return contaDIN;
    }

    public void setContaDIN(int contaDIN) {
        this.contaDIN = contaDIN;
    }

    public int getContaDON() {
        return contaDON;
    }

    public void setContaDON(int contaDON) {
        this.contaDON = contaDON;
    }

    public int getContaDAN() {
        return contaDAN;
    }

    public void setContaDAN(int contaDAN) {
        this.contaDAN = contaDAN;
    }
    
    
    
    /**
     * 
     * @param c Indico la scelta effettuata dall'untete fatta nel main
     * 
     * @return indica se hai vinto o no.
     * 
     */
    public synchronized String verificaSeHaiVinto(int c) {
        String x="Hai Perso";
        if(c==1 && contaDIN>contaDON && contaDIN>contaDAN) {
            x="Hai Vinto!";
        }
        if(c==2 && contaDON>contaDIN && contaDON>contaDAN) {
            x="Hai Vinto!";
        }
        if(c==3 && contaDAN>contaDON && contaDAN>contaDON) {
            x="Hai Vinto!";
        }
        return x;
    }
    public synchronized void aggiungi(String x) {
        if (p >= maxElem)
            p = 0;
        schermo[p]=x;
        p+=1;
    }
    public synchronized void printSchermo() {
        System.out.println("-------------------------------");
        for (int i = 0; i < p; i ++) {
            System.out.print(schermo[i] + " ");
            if (i % 20 == 19)
                System.out.println("");
        }
        System.out.println("\n-------------------------------");
    }
}
