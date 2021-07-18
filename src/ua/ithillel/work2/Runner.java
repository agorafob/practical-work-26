package ua.ithillel.work2;

import java.util.Random;

public class Runner{

    public void run() throws InterruptedException {
        System.out.println("i run from work2");
        DiningHall d = new DiningHall();
        for (int i = 0; i < 10; i++) {
            d.makePizza();
        }
        synchronized (d) {
            Thread student;
            for (int i = 1; i <= 20; i++) {
                if (i > 10) {
                    d.makePizza();
                }
                student = new Thread(()->d.servePizza());
                student.start();
                student.join();
            }
        }

    }
}




