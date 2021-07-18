package ua.ithillel.work3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {


    public void run() throws InterruptedException {
        System.out.println("i run from work3");
        long startCC = System.nanoTime();
        Map<Integer, Integer> ccTestMap = new ConcurrentHashMap<>();
        for (int i = 1; i <= 10; i++) {
            Thread writeCC = new Thread(new MyThreadWriteToMap(ccTestMap));
            Thread readCC = new Thread(new MyThreadReadFromMap(ccTestMap));
            writeCC.start();
            readCC.start();
            writeCC.join();
            readCC.join();
        }
        long finishCC = System.nanoTime();
        long concurentResult = finishCC-startCC;
        System.out.println("Total time = " + concurentResult+" ms");

//        synchronized (this) {
//            long startHM = System.nanoTime();
//            Map<Integer, Integer> hmTestMap = new HashMap<>();
//            for (int i = 1; i <= 10; i++) {
//                Thread writeHM = new Thread(new MyThreadWriteToMap(hmTestMap));
//                Thread readHM = new Thread(new MyThreadReadFromMap(hmTestMap));
//                writeHM.start();
//                readHM.start();
//                writeHM.join();
//                readHM.join();
//            }
//            long finishHM = System.nanoTime();
//            long hmResult = finishHM - startHM;
//            System.out.println("Total time = " + hmResult + " ms");
//            System.out.println("Difference = " + (concurentResult-hmResult));
//        }
    }
}
