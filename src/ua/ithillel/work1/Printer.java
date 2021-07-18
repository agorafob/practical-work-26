package ua.ithillel.work1;

import javax.swing.*;

public class Printer implements Runnable {
    private final Storage storage;

    public Printer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage) {
            System.out.println("p start");
            for (int i = 0; i < 1001; i++) {
                System.out.println(storage.getNumber());
                storage.notify();
                try {
                    if(storage.getNumber()!=1000){
                        storage.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("p finish");
        }
    }
}





