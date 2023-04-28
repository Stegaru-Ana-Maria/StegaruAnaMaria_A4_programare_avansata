package org.example;
import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {

    private final List<Token>[][] matrix;
    Exploration explore;

    public ExplorationMap(int row_size, int column_size, Exploration explore) {
        this.explore = explore;
        matrix = new List[row_size][column_size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }
    }


    public boolean visit(int row, int column, Robot robot) {
        synchronized (matrix[row][column]) {
            if (row >= 0 || row < 3 || column >= 0 || column < 3 || matrix[row][column].isEmpty()) {
                matrix[row][column].add(explore.getMemory().extractTokens(1).get(0));
                robot.addToCount(1);
                System.out.println(robot.getName() + " successfuly visited the cell with row = " + row + " and column = " + column);
                return true;
            }
            else {
                System.out.println(robot.getName() + " failed to visit cell [" + row + "," + column + "]");
                return false;
            }
        }
    }

    public List<Token>[][] getMatrix() {
        return matrix;
    }


    @Override
    public String toString() {
        return "ExplorationMap{" + "matrix=" + matrix + '}';
    }
}
