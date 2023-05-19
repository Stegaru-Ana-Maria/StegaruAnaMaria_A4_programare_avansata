package org.example;
public class Game {
    public static final int P1 = 0;
    public static final int P2 = 1;
    public static final int DRAW = 2;
    public static final int CONTINUE = 3;

    private Board board;
    private Player player1;
    private Player player2;
    private int currentPlayerTurn;

    public Game(Player player1, Player player2) {
        this(player1, player2, 15);
    }

    public Game(Player player1, Player player2, int boardSize) {
        this.board = new Board(boardSize);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayerTurn = P1;
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    public int makeMove(int player, int row, int col) {
        if (player != currentPlayerTurn) {
            // It's not the current player's turn
            return CONTINUE;
        }

        if (!board.isValidMove(row, col)) {
            // Invalid move
            return CONTINUE;
        }

        char piece = (player == P1) ? player1.getPiece() : player2.getPiece();
        board.placePiece(row, col, piece);

        if (board.checkWin(row, col)) {
            // Current player wins
            return player;
        }

        if (board.isFull()) {
            // It's a draw
            return DRAW;
        }

        // Switch to the next player's turn
        currentPlayerTurn = (currentPlayerTurn == P1) ? P2 : P1;

        return CONTINUE;
    }
}

