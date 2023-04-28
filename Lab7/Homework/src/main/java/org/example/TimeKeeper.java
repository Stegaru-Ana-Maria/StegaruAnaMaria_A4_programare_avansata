package org.example;
import static java.lang.Thread.sleep;

public class TimeKeeper implements Runnable {

    int time = 0;
    private volatile boolean running = true;


    @Override
    public void run() {
        while (running) {
            time++;
            System.out.println("Running time : " + time);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if(time == 60){
                System.exit(0);
            }
        }
    }

}