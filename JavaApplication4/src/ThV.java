/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pizzd
 */
public class ThV extends Thread{
     private DatiCondivisi ptrDati;

    public ThV(DatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        try {
            while (true) {

                ptrDati.waitSV1();
                
                System.out.println(ptrDati.getRintocco());                
                if(ptrDati.getRintocco().equals("DAN")){
                    System.out.println();
                }
                
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                ptrDati.signalSV2();

            }
        } catch (InterruptedException ex) {
            
        }
    }
}
