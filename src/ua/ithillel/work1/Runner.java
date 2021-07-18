package ua.ithillel.work1;

public class Runner {
    public synchronized void run() throws InterruptedException {
        System.out.println("i run from work1");
        Storage storage = new Storage();
        Counter counter = new Counter(storage);
        Printer printer = new Printer(storage);
        Thread th1 = new Thread(counter);
        Thread th2 = new Thread(printer);
        th1.start();
        th2.start();

    }
}
