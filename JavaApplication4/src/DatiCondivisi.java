
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

    private String rintocco;
 
      private Semaphore sDin;
    private Semaphore sDon;
    private Semaphore sDan;
    
    private Semaphore s1;
    private Semaphore s2;
    private Semaphore s3;
    private Semaphore sV1;
    private Semaphore sV2;
    
    public DatiCondivisi() {
        sDin = new Semaphore(0);
        sDon = new Semaphore(0);
        sDan = new Semaphore(0);
        
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
        
        sV1 = new Semaphore(0);
        sV2 = new Semaphore(1);
    }
    
     public void waitSV1() throws InterruptedException {
        sV1.acquire();
    }

    public void signalSV1() {
        sV1.release();
    }
    
    public void waitSV2() throws InterruptedException {
        sV2.acquire();
    }

    public void signalSV2() {
        sV2.release();
    }
    public void waitS1() throws InterruptedException {
        s1.acquire();
    }

    public void signalS1() {
        s1.release();
    }

    public void waitS2() throws InterruptedException {
        s2.acquire();
    }

    public void signalS2() {
        s2.release();
    }

    public void waitS3() throws InterruptedException {
        s3.acquire();
    }

    public void signalS3() {
        s3.release();
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
    public synchronized void setRintocco(String x) {
        rintocco = x;
    }
    public synchronized String getRintocco() {
        return rintocco;
    }
}
