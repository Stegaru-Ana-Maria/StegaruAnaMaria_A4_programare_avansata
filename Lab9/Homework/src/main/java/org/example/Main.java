package org.example;

public class Main {

    public static void main(String[] args) {
        Singleton s = new Singleton();
        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= 100; i++) {
            s.insertAlbum();
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Run time is " + elapsedTime + "ms .");
    }
}