package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Robot implements Runnable {
    private String name;
    private int[][] map;
    private Set<Point> visited;
    private List<Token> tokens;
    private Random random;
    private Object lock;
    private boolean running;
    private SharedMemory sharedMemory;
    private Exploration explore;
    private Thread thread;

    public Robot(String name, Exploration explore, List<Token> tokens, SharedMemory sharedMemory) {
        this.name = name;
        this.running = true;
        this.explore = explore;
        this.tokens = tokens;
        this.sharedMemory = sharedMemory;
        this.thread = new Thread(this, name);
    }

    public void run() {
        while (running) {
            int[][] map = explore.getMap();
            int x = (int) (Math.random() * map.length);
            int y = (int) (Math.random() * map[0].length);
            synchronized (map) {
                if (map[x][y] == 0) {
                    System.out.println(name + " visited (" + x + "," + y + ")");
                    map[x][y] = tokens.remove(0).getValue();
                }
            }

        }
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public String getName() {
        return name;
    }

    public void stopRunning() {
        this.running = false;
    }

    public List<Token> extractTokens(int n) {
        List<Token> extractedTokens = new ArrayList<>();
        synchronized (sharedMemory) {
            for (int i = 0; i < n; i++) {
                if (!sharedMemory.isEmpty()) {
                    Token token = sharedMemory.remove(0);
                    extractedTokens.add(token);
                } else {
                    break;
                }
            }
        }
        return extractedTokens;
    }
}