package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exploration {
    private int[][] map;
    private List<Token> tokens;
    private List<Robot> robots;
    private boolean running;

    public void start(int n, int numRobots) {
        this.map = new int[n][n];
        this.tokens = generateTokens(n);
        this.robots = new ArrayList<>();
        this.running = true;
        for (int i = 1; i <= numRobots; i++) {
            String name = "Robot" + i;
            Robot robot = new Robot(name, this, tokens, new SharedMemory(n * n * n));
            robots.add(robot);
            Thread thread = new Thread(robot);
            thread.start();
        }
    }


    private List<Token> generateTokens(int n) {
        List<Token> tokens = new ArrayList<>();
        for (int i = 1; i <= n * n * n; i++){
            Token token = new Token(i);
            tokens.add(token);
        }
        Collections.shuffle(tokens);
        return tokens;
    }

    public void stopRunning(){
        for (Robot robot : robots){
            robot.stopRunning();
        }
    }

    public int[][] getMap(){
        return map;
    }
}
