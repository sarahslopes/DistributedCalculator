package org.example.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1", 1500), 1000);

        System.out.println("Connection Successful!");
    }
}
