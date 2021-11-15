package com.tangtang.basic.socket.step3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Step3Server {

    ServerSocket serverSocket;

    IHandlerInterface httpHandler;

    public Step3Server(IHandlerInterface handlerInterface) {
        this.httpHandler = handlerInterface;
    }

    public void listen(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    accept(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void accept(Socket socket) throws IOException {
        Request request = new Request(socket);
        Response response = new Response(socket);
        httpHandler.handler(request, response);
    }


    public static void main(String[] args) throws IOException {
        Step3Server step3Server = new Step3Server((request, response) -> {
            response.send(400,"<html><body><h1>Yes</h1></body></html>");
        });
        step3Server.listen(8000);
    }
}
