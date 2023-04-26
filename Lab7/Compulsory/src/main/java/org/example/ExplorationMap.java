package org.example;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int n;
    private int numVisited;

    public ExplorationMap(int n) {
        this.n = n;
        this.matrix = new Cell[n][n];
        this.numVisited = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].isVisited()) {
                List<Token> tokens = robot.extractTokens(n);
                matrix[row][col].setTokens(tokens);
                matrix[row][col].setVisited(true);
                System.out.println(robot.getName() + " successfully visited cell [" + row + "," + col + "]");
                return true;
            } else {
                System.out.println(robot.getName() + " failed to visit cell [" + row + "," + col + "]");
                return false;
            }
        }
    }

    public synchronized boolean isFullyVisited() {
        return numVisited == n * n;
    }

    @Override
    public synchronized String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j].toString()).append(" ");
            }
        }
        return sb.toString();
    }
}

