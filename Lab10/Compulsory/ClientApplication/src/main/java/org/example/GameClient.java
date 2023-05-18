package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    private static final String localhost = "127.0.0.1"; // The server's IP address
    private static final int PORT = 8200; // The server's port
    public static void main(String[] args) throws IOException {

        try (
                Socket socket = new Socket(localhost, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Send a request to the server
            String request = "stop";
            out.println(request);
            String response = in.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

