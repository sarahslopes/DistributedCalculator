package org.example.server;

import org.example.Calculator;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static org.example.operation.BigDecimalUtils.stringToArrayList;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        connection();
    }

    public static void connection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1501);
        System.out.println("Server started on port 1500...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client Connection Successful!");

        communication(serverSocket, clientSocket);
    }

    public static void communication(ServerSocket serverSocket, Socket clientSocket) throws IOException {
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
        int option;

        do {
            option = dataIn.readInt();
            String line = dataIn.readUTF();

            System.out.println("Start calculator service...");
            calculatorAdapter(line, option);
        } while (option != 5);

        dataOut.close();
        dataIn.close();

        clientSocket.close();
        serverSocket.close();
    }

    private static void calculatorAdapter(String inputLine, int option) {
        ArrayList<BigDecimal> numbers = stringToArrayList(inputLine);
        Calculator calculator = new Calculator();
        calculator.menu(option, numbers);
    }
}
