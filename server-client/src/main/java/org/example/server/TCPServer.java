package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1500);
        System.out.println("Server started on port 1500...");

        Socket client = server.accept();
        String clientIP = client.getInetAddress().toString();
        int clientPort = client.getPort();

        System.out.println("[IP: " + clientIP + " ,Port: " + clientPort +"]  " + "Client Connection Successful!");
    }
}
