package SocketProgramming;

import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for a client to connect...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Create input and output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from client
            String clientMessage = input.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Process data (e.g., convert to uppercase)
            String processedMessage = clientMessage.toUpperCase();

            // Send processed data back to client
            output.println(processedMessage);
            System.out.println("Sent to client: " + processedMessage);

            // Close connections
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
