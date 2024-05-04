package org.example.client;

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
                    "Insira os valores a serem operados:");

            String line = stringScanner.nextLine();

            dataOut.writeInt(option);
            dataOut.writeUTF(line);

            System.out.println("\n" +
                    "Establishing connection to the server...");
        } while (option != 5);


        dataIn.close();
        dataOut.close();
        clientSocket.close();
    }

    public static void printMenu() {
        System.out.println(
                "\nDigite o número correspondente à operação desejada:\n" +
                        "1 - Soma\n" +
                        "2 - Subtração\n" +
                        "3 - Multiplicação\n" +
                        "4 - Divisão\n" +
                        "5 - Sair"
        );
    }
}
