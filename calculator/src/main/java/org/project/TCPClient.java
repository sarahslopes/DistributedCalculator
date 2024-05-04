package org.project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) throws IOException {
        connection();
    }

    public static void connection() throws IOException {
        Socket clientSocket = new Socket();
        clientSocket.connect(new InetSocketAddress("127.0.0.1", 1501), 1000);
        System.out.println("Connection Successful!");
        communication(clientSocket);
    }

    public static void communication(Socket clientSocket) throws IOException {
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        int option;

        do {
            printMenu();
            option = scanner.nextInt();

            System.out.println("\n" +
                    "Enter the values to be operated:");

            String line = stringScanner.nextLine();

            dataOut.writeInt(option);
            dataOut.writeUTF(line);

            System.out.println("\n" +
                    "Establishing connection to the server...");

            String result = dataIn.readUTF();
            System.out.println(result);
        } while (option != 5);

        dataIn.close();
        dataOut.close();
        clientSocket.close();
    }

    public static void printMenu() {
        System.out.println(
                "\nEnter the number corresponding to the desired operation:\n" +
                        "1 - Sum\n" +
                        "2 - Subtract\n" +
                        "3 - Multiplication\n" +
                        "4 - Division\n" +
                        "5 - Exit"
        );
    }
}
