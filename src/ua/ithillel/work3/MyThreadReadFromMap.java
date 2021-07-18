package ua.ithillel.work3;

import java.util.Map;

public class MyThreadReadFromMap implements Runnable {
    Map<Integer,Integer> map ;

    public MyThreadReadFromMap(Map<Integer, Integer> map) {
        this.map = map;
    }

    private void readFromMap(){
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+"-"+this.map.get(i));
        }
    }

    @Override
    public void run() {
        readFromMap();
    }
}
