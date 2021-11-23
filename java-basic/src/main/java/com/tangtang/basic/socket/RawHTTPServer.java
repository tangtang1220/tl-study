package com.tangtang.basic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RawHTTPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8000);

        while (true) {
            System.out.println("Create a Socket");
            // Blocking...
            Socket accept = socket.accept();

            DataInputStream reader = new DataInputStream(new BufferedInputStream(accept.getInputStream()));

            StringBuilder requestBuilder = new StringBuilder();
            String line = "";
            while (!(line = reader.readLine()).isEmpty()) {
                requestBuilder.append(line + '\n');
            }
            System.out.println(requestBuilder);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            writer.write("HTTP/1.1 200 ok\n\nHello World!\n");
            writer.flush();
            writer.close();
        }
    }
}
