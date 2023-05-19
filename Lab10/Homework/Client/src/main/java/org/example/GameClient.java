package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

    private String serverAddress = "127.0.0.1";
    private int port = 8101;

    private static final int BOARD_SIZE = 15;

    public void startClient() {
        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner console = new Scanner(System.in);

            while (true) {
                System.out.println("Enter a command: ");
                String command = console.nextLine();

                out.println(command);

                if (command.equalsIgnoreCase("exit")) {
                    System.out.println("Client stopped.");
                    break;
                } else if (command.equalsIgnoreCase("create game")) {
                    String response = in.readLine();
                    System.out.println("Server response: " + response);
                } else if (command.startsWith("join game")) {
                    out.println(command); // Send the join game command to the server
                    String response = in.readLine(); // Handle the response from the server
                    System.out.println("Server response: " + response);
                }
                else if (command.startsWith("submit move")) {
                    String[] parts = command.split(" ");
                    if (parts.length == 4) {
                        int row;
                        int col;
                        try {
                            row = Integer.parseInt(parts[2]);
                            col = Integer.parseInt(parts[3]);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid row or column values. Please enter integers for row and column.");
                            continue;
                        }

                        // Validate row and col values...
                        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                            System.out.println("Invalid row or column values. Please enter values within the board range.");
                            continue;
                        }

                        // Send the move to the server
                        out.println("submit move");
                        out.println(row);
                        out.println(col);

                        // Handle the response from the server
                        String response = in.readLine();
                        System.out.println("Server response: " + response);
                    } else {
                        System.out.println("Invalid command format. Usage: submit move <row> <col>");
                    }
                } else {
                    System.out.println("Unknown command: " + command);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            System.err.println("Error occurred during communication with the server... " + e);
        }
    }

    public static void main(String[] args) {
        GameClient client = new GameClient();
        client.startClient();
    }
}


