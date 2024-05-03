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
        clientSocket.connect(new InetSocketAddress("127.0.0.1", 1500), 1000);
        System.out.println("Connection Successful!");

        communication(clientSocket);
    }

    public static void communication(Socket clientSocket) throws IOException {
        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        printMenu();

        int option = scanner.nextInt();
        dataOut.writeInt(option);

        dataIn.close();
        dataOut.close();
        clientSocket.close();
    }

    public static void printMenu() {
        System.out.println(
                "Digite o número correspondente à operação desejada:\n" +
                        "1 - Soma\n" +
                        "2 - Subtração\n" +
                        "3 - Multiplicação\n" +
                        "4 - Divisão\n" +
                        "5 - Sair\n\n"
        );
    }
}
