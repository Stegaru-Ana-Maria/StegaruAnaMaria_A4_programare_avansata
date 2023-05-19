package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    private static final int PORT = 8101;
    private static final int MAX_PLAYERS = 2;
    private static final int BLITZ_TIME_LIMIT = 120; // Blitz time limit in seconds

    private int currentPlayerId = 1;
    private int numPlayers = 0;
    private long startTime;
    private long[] remainingTime; // Remaining time for each player in milliseconds

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for players to connect...");

            while (numPlayers < MAX_PLAYERS) {
                Socket clientSocket = serverSocket.accept();
                numPlayers++;
                System.out.println("Player " + numPlayers + " connected.");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("You are player " + numPlayers);

                if (numPlayers == 1) {
                    startTime = System.currentTimeMillis();
                    remainingTime = new long[MAX_PLAYERS];
                    remainingTime[0] = BLITZ_TIME_LIMIT * 1000;
                }

                PlayerHandler playerHandler = new PlayerHandler(clientSocket, numPlayers);
                Thread playerThread = new Thread(playerHandler);
                playerThread.start();
            }

            System.out.println("Game started with " + numPlayers + " players.");
            // Start the game logic here

        } catch (IOException e) {
            System.err.println("Error occurred while running the server: " + e.getMessage());
        }
    }

    private class PlayerHandler implements Runnable {
        private Socket clientSocket;
        private int playerId;

        public PlayerHandler(Socket clientSocket, int playerId) {
            this.clientSocket = clientSocket;
            this.playerId = playerId;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String command;
                while ((command = in.readLine()) != null) {
                    if (command.equalsIgnoreCase("exit")) {
                        System.out.println("Player " + playerId + " disconnected.");
                        break;
                    } else if (command.equalsIgnoreCase("create game")) {
                        handleCreateGame();
                    } else if (command.startsWith("join game")) {
                        handleJoinGame(command);
                    } else if (command.startsWith("submit move")) {
                        handleMove(command);
                    } else {
                        System.out.println("Unknown command from player " + playerId + ": " + command);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error occurred while communicating with player " + playerId + ": " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error occurred while closing the connection with player " + playerId + ": " + e.getMessage());
                }
            }
        }

        private void handleCreateGame() {
            if (numPlayers == 1) {
                System.out.println("Game created. You are player " + playerId);
            } else {
                System.out.println("Cannot create game. Maximum number of players reached.");
            }
        }

        private void handleJoinGame(String command) throws IOException {
            if (numPlayers == MAX_PLAYERS) {
                System.out.println("Cannot join game. Maximum number of players reached.");
                return;
            }

            numPlayers++;
            System.out.println("Player " + numPlayers + " joined the game.");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("You are player " + numPlayers);

            if (numPlayers == 1) {
                startTime = System.currentTimeMillis();
                remainingTime = new long[MAX_PLAYERS];
                remainingTime[0] = BLITZ_TIME_LIMIT * 1000;
            }
        }



        private void handleMove(String command) {
            String[] parts = command.split(" ");
            if (parts.length == 3) {
                String move = parts[2];
                // Process the move...
                System.out.println("Player " + playerId + " submitted move: " + move);
            } else {
                System.out.println("Invalid command format. Usage: submit move <move>");
            }
        }

    }

    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.startServer();
    }
}
