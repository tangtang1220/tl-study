package com.tangtang.basic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;
import java.util.function.Function;

public class Step1Server {

    ServerSocket serverSocket;

    Function<String, String> handler;

    public Step1Server(Function<String, String> handler) throws IOException {
        this.handler = handler;
    }

    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            accept();
        }
    }

    public void accept() throws IOException {
        try {
            System.out.println("Create a Socket");

            Socket accept = serverSocket.accept();

            DataInputStream reader = new DataInputStream(new BufferedInputStream(accept.getInputStream()));

            StringBuilder requestBuilder = new StringBuilder();
            String line = "";
            while (!(line = reader.readLine()).isEmpty()) {
                requestBuilder.append(line + '\n');
            }
            String request = requestBuilder.toString();
            System.out.println(request);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            writer.write(handler.apply(request));
            writer.flush();
            writer.close();
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Step1Server server = new Step1Server(req -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return "HTTP/1.1 200 ok\n\nGood!\n";
        });
        server.listen(8000);

    }
}
