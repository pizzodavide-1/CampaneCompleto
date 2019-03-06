/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Princess Joy Padua
 *
 * @brief Classe per la gestione dei suoni
 *
 *
 */
public class ThSuono extends Thread {

    private String suono;

 
    DatiCondivisi ptrdati;

    public ThSuono(String x, DatiCondivisi p) {
        suono = x;
        ptrdati = p;
    }

    /**
     * @brief Metodo per eseguire l'istruzione.
     *
     */
    public void run() {
        boolean controllo = true;
        try {
            while (controllo == true) {
                
               switch (this.suono) {
                    case "DIN":
                        ptrdati.waitS1();
                        continua();
                        ptrdati.signalS2();
                        break;
                        
                    case "DON":
                        ptrdati.waitS2();
                        continua();
                        ptrdati.signalS3();
                        break;
                        
                    case "DAN":
                        ptrdati.waitS3();
                        continua();
                        ptrdati.signalS1();
                        break;
                }
            Thread.sleep((int) (Math.random() * 10));

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        } catch (InterruptedException ex) {

        }
        switch (this.suono) {
            case "DIN":
                ptrdati.signalSDin();
                break;
            case "DON":
                ptrdati.signalSDon();
                break;
            case "DAN":
                ptrdati.signalSDan();
                break;

        }
    }

    public void continua() {
        try {
            
            ptrdati.waitSV2();
            ptrdati.setRintocco(suono);
            ptrdati.signalSV1();
            
        } catch (InterruptedException ex) {

        }
    }
}