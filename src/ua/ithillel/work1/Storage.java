package ua.ithillel.work1;

public class Storage {
    private volatile int number;

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}
