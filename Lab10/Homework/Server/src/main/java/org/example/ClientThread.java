package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private Game game;

    public ClientThread(Socket socket, Player player1, Player player2) {
        this.socket = socket;
        this.game = new Game(player1, player2);
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            int player = Integer.parseInt(in.readLine());
            int opponent = (player == Game.P1) ? Game.P2 : Game.P1;

            out.println(game.getCurrentPlayerTurn());

            while (true) {
                if (game.getCurrentPlayerTurn() == player) {
                    int row = Integer.parseInt(in.readLine());
                    int col = Integer.parseInt(in.readLine());

                    int result = game.makeMove(player, row, col);
                    if (result == Game.CONTINUE) {
                        out.println(Game.CONTINUE);
                        out.println(game.getCurrentPlayerTurn());
                    } else {
                        out.println(result);
                        break;
                    }
                } else {
                    out.println(Game.CONTINUE);
                    out.println(game.getCurrentPlayerTurn());
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error: " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
