package ua.ithillel.work3;

import java.util.Map;
import java.util.Random;

public class MyThreadWriteToMap implements Runnable {
   Map<Integer,Integer> map ;

    public MyThreadWriteToMap(Map<Integer, Integer> map) {
        this.map = map;
    }

    private void writeToMap(){
        Random number = new Random();
        for (int i = 1; i <= 10; i++) {
            int value = number.nextInt(20);
            this.map.put(i,value);
        }
    }

    @Override
    public void run() {
        writeToMap();

    }
}
