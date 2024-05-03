package org.example.server;

import org.example.Calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        connection();
    }

    public static void connection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1500);
        System.out.println("Server started on port 1500...");

        Socket clientSocket = serverSocket.accept();
        String clientIP = clientSocket.getInetAddress().toString();
        int clientPort = clientSocket.getPort();
        System.out.println("[IP: " + clientIP + " ,Port: " + clientPort + "]  " + "Client Connection Successful!");

        communication(serverSocket, clientSocket);
    }

    public static void communication(ServerSocket serverSocket, Socket clientSocket) throws IOException {
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

        int option = dataIn.readInt();

        System.out.println("Inicia serviço calculadora...");
        Calculator calculator = new Calculator();
        calculator.selectorMenu(option);

        dataOut.close();
        dataIn.close();
        clientSocket.close();
        serverSocket.close();
    }
}
