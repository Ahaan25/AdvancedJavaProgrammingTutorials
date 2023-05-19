package SocketProgramming;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create client socket and connect to the server
            Socket clientSocket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("Connected to server: " + clientSocket.getInetAddress());

            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send data to the server
            String messageToSend = "Hello, server!";
            output.println(messageToSend);
            System.out.println("Sent to server: " + messageToSend);

            // Receive processed data from the server
            String serverResponse = input.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close connections
            input.close();
            output.close();
            clientSocket.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
