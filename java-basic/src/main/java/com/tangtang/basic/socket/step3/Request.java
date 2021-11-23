package com.tangtang.basic.socket.step3;

import java.io.*;
import java.net.Socket;

public class Request {

    Socket socket;

    public Request(Socket socket) throws IOException {
        this.socket = socket;
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(dataInputStream));
        StringBuilder builder = new StringBuilder();
        String line = "";
        while (!(line = reader.readLine()).isEmpty()) {
            builder.append(line + "\n");
        }
        String data = builder.toString();
        System.out.println(data);
    }


}
