package org.example;

import java.util.Scanner;

public class Player {
    private char piece;
    private String name;

    public Player(char piece, String name) {
        this.piece = piece;
        this.name = name;
    }

    public char getPiece() {
        return piece;
    }

    public String getName() {
        return name;
    }

    public Move getMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player " + name + ", enter your move (row column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.isValidMove(row, col)) {
                return new Move(row, col);
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

}

