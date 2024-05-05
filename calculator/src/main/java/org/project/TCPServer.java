package org.project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        connection();
    }

    public static void connection() throws IOException {
        ServerSocket serverSocket = new ServerSocket(15000);
        System.out.println("Server started on port 15000...");

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

            String result = menu(option, numbers);

            dataOut.writeUTF(result);
        } while (option != 5);

        dataOut.close();
        dataIn.close();

        clientSocket.close();
        serverSocket.close();
    }

    public static ArrayList<BigDecimal> parseInputToBigDecimalList(String receivedLine) {
        Scanner scannerString = new Scanner(receivedLine);
        ArrayList<BigDecimal> numbers = new ArrayList<>();

        while (scannerString.hasNextBigDecimal()) {
            BigDecimal number = scannerString.nextBigDecimal();
            numbers.add(number);
        }

        scannerString.close();
        return numbers;
    }

    public static String menu(int selectedOption, ArrayList<BigDecimal> numbers) {
        String result = null;

        switch (selectedOption) {
            case 1:
                result = performOperation(numbers, TCPServer::sum, "Sum result: ");
                break;
            case 2:
                result = performOperation(numbers, TCPServer::subtract, "Subtraction result: ");
                break;
            case 3:
                result = performOperation(numbers, TCPServer::multiply, "Multiplication result: ");
                break;
            case 4:
                result = performOperation(numbers, TCPServer::divide, "Division result: ");
                break;
            case 5:
                System.out.println("Closing the system...");
                break;
            default:
                result = "Insert a valid option!";
                break;
        }

        return result;
    }

    private static final Integer MAX_NUMBERS =  20;

    public static boolean isOperationValid(List<BigDecimal> numbersReceived) {
        return numbersReceived.size() < MAX_NUMBERS;
    }

    public static String performOperation(ArrayList<BigDecimal> numbers, OperationFunction operationFunction, String message) {
        if (!isOperationValid(numbers)) {
            return "To perform the operation, enter a maximum of 20 numbers.";
        }

        BigDecimal result = operationFunction.apply(numbers);
        return message + result;
    }

    public static BigDecimal sum(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal subtract(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal::subtract)
                .orElse(BigDecimal.ZERO);
    }

    public static BigDecimal multiply(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce(BigDecimal.ONE, BigDecimal::multiply);
    }

    public static BigDecimal divide(List<BigDecimal> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a.divide(b, RoundingMode.HALF_UP))
                .orElse(BigDecimal.ONE);
    }

    @FunctionalInterface
    public interface OperationFunction {
        BigDecimal apply(ArrayList<BigDecimal> numbers);
    }
}
