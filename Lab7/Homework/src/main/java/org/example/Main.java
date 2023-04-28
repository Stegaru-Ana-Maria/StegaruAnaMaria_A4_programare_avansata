package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var explore = new Exploration(3,3);
        MainFrame frame = new MainFrame(explore);
        frame.setVisible(true);
        explore.addRobot(new Robot("Robot1", explore));
        explore.addRobot(new Robot("Robot2", explore));
        explore.start();
    }
}