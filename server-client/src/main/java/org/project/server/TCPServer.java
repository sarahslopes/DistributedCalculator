package org.project.server;

import org.project.calculator.CalculatorService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static org.project.calculator.CalculatorOperations.parseInputToBigDecimalList;

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

            ArrayList<BigDecimal> numbers = parseInputToBigDecimalList(line);

            CalculatorService calculatorService = new CalculatorService();
            String result = calculatorService.menu(option, numbers);

            dataOut.writeUTF(result);
        } while (option != 5);

        dataOut.close();
        dataIn.close();

        clientSocket.close();
        serverSocket.close();
    }
}
