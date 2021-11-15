package com.tangtang.basic.socket.step3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;

public class Response {

    Socket socket;

    int status;

    HashMap<Integer, String> statusMap = new HashMap<>();

    public Response(Socket socket) throws IOException {
        this.socket = socket;
        statusMap.put(200, "OK");
        statusMap.put(400, "Failed");
    }

    public void send(int status, String msg) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HTTP/1.1 " + status + " " + statusMap.get(status) + "\n\n" + msg + "\n");
        bufferedWriter.flush();
        socket.close();
    }
}
