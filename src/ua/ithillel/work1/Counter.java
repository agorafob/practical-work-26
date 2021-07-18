package ua.ithillel.work1;

public class Counter implements Runnable {
    private final Storage storage;

    public Counter(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        synchronized (storage) {
            System.out.println("c start");
            for (int i = 0; i < 1001; i++) {
                storage.setNumber(i);
                storage.notify();
                try {
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c finish");
        }
    }
}

