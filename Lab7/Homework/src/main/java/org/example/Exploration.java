package org.example;
import java.util.ArrayList;
import java.util.List;

public class Exploration {

    private final SharedMemory memory = new SharedMemory(10);
    private final ExplorationMap map;
    private final List<Robot> robots = new ArrayList<>();
    public final Object lock = new Object();

    public Exploration(int row, int col) {
        map = new ExplorationMap(row,col,this);
    }

    public void start() {
        Thread timer = new Thread(new TimeKeeper());
        timer.setDaemon(true);
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
        timer.start();
    }

    public SharedMemory getMemory() {
        return memory;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public void checkCommand(String text) throws InterruptedException {
        String all = "all";
        System.out.println("I received the command: " + text);

        if (text.startsWith("pause")) {
            String name = text.substring(6);
            if(name.compareTo(all) == 0){
                for (Robot robot : robots){
                    robot.setCommand("p");

                }
            }
            for (Robot robot : robots) {
                if (robot.getName().compareTo(name) == 0) {
                    robot.setCommand("p");
                }
            }
        } else if (text.startsWith("start")) {
            String name = text.substring(6);
            if(name.compareTo(all) == 0){
                for (Robot robot : robots){
                    robot.setCommand("sa");

                }
            }
            for (Robot robot : robots) {
                if (robot.getName().compareTo(name) == 0) {
                    robot.setCommand("s");
                }
            }
        }
    }
}