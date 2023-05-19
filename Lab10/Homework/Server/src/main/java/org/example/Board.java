package org.example;

public class Board {
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize the board with empty spaces
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        // Check if the move is within the board boundaries and the cell is empty
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ';
    }

    public void placePiece(int row, int col, char piece) {
        // Place the player's piece on the board at the specified position
        board[row][col] = piece;
    }

    public boolean checkWin(int row, int col) {
        char piece = board[row][col];

        // Check horizontal line
        int count = 0;
        for (int c = 0; c < size; c++) {
            if (board[row][c] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check vertical line
        count = 0;
        for (int r = 0; r < size; r++) {
            if (board[r][col] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonal line (top-left to bottom-right)
        count = 0;
        int r = row;
        int c = col;
        while (r > 0 && c > 0) {
            r--;
            c--;
        }
        while (r < size && c < size) {
            if (board[r][c] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
            r++;
            c++;
        }

        // Check diagonal line (top-right to bottom-left)
        count = 0;
        r = row;
        c = col;
        while (r > 0 && c < size - 1) {
            r--;
            c++;
        }
        while (r < size && c >= 0) {
            if (board[r][c] == piece) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
            r++;
            c--;
        }

        return false;
    }

    public boolean isFull() {
        // Check if the board is full (no empty cells)
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sb.append(board[row][col]);
                if (col != size - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
            if (row != size - 1) {
                sb.append("-".repeat(4 * size - 1));
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}


