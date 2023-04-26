package org.example;

public class Main {
    public static void main(String[] args) {
        Exploration exploration = new Exploration();
        exploration.start(5, 2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        exploration.stopRunning();
        System.out.println("Exploration stopped.");
    }
}