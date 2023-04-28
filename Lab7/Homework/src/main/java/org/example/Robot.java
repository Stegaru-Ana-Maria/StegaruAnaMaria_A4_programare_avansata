package org.example;
public class Robot implements Runnable {

    private String name;
    Exploration explore;
    private int startPosRow;
    private int startPosColumn;
    private int count;
    private volatile String command = " ";
    private volatile boolean running = true;

    public Robot(String name, Exploration explore) {
        int min = 0;
        int max = 2;
        int range = (max - min) + 1;
        this.name = name;
        this.explore = explore;
        this.startPosRow = (int) (Math.random() * range) + min;
        this.startPosColumn = (int) (Math.random() * range) + min;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void addToCount(int howMuch) {
        this.count += howMuch;
    }

    public void stop() {
        setRunning(false);
    }

    public void sleep(int time) throws InterruptedException {
        Thread.sleep(time);
        System.out.println("Robot " + this.name + " is sleeping for " + time + "ms.");
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void show() {
        for (int i = 0; i < explore.getMap().getMatrix().length; i++) {
            for (int j = 0; j < explore.getMap().getMatrix()[i].length; j++) {
                System.out.println("i= " + i + " j= " + j);
                System.out.println(System.lineSeparator());
                System.out.println(explore.getMap().getMatrix()[i][j]);
            }

        }
    }

    public synchronized void stopIndefinately(Token notif) throws InterruptedException {
        synchronized(notif){
            System.out.println("Robot " + this.name + " has been paused. Waiting for restart.");
            notif.wait();
        }
    }

    public synchronized void start(Token notif) {
        synchronized(notif){
            System.out.println("Robot " + this.name + " has been started.");
            notif.notify();
        }
    }

    public synchronized void startAll(Token notif) {
        synchronized(notif){
            System.out.println("All robots have started.");
            notif.notifyAll();
        }
    }

    @Override
    public void run() {
        while (isRunning()) {
            System.out.println(this.name + " started on the positions: row = " + this.startPosRow + " column = " + this.startPosColumn);
            for (int i = 0; i < explore.getMap().getMatrix().length; i++) {
                for (int j = 0; j < explore.getMap().getMatrix()[i].length; j++) {
                    if(this.getCommand().compareTo("p") == 0){
                        synchronized(explore.lock){
                            try {
                                explore.lock.wait();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        this.setCommand(" ");
                    }
                    else if(this.getCommand().compareTo("s") == 0){
                        synchronized(explore.lock){
                            explore.lock.notify();
                        }
                        this.setCommand(" ");
                    }
                    else if(this.getCommand().compareTo("sa") == 0){
                        synchronized(explore.lock){
                            explore.lock.notifyAll();
                        }
                        this.setCommand(" ");
                    }
                    explore.getMap().visit(i, j, this);
                    try {
                        this.sleep(5000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            this.stop();
            System.out.println(this.name + " has placed " + this.count + " tokens.");
            this.show();
        }

    }
}