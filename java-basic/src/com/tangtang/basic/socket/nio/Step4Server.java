package com.tangtang.basic.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Step4Server {

    ServerSocketChannel ssc;

    public void listen(int port) {
        try {
            ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));
            // 非阻塞
            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            ssc.register(selector, ssc.validOps(), null);

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 16);

            for (; ; ) {
                int numOfKeys = selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isAcceptable()) {
                        SocketChannel channel = ssc.accept();
                        if (channel == null) {
                            continue;
                        }
                        // Kernel -> map(buffer) -> Channel -> User(Buffer)
                        channel.configureBlocking(false);
                        channel.register(selector, SelectionKey.OP_READ);

                    } else {
                        SocketChannel channel = (SocketChannel) key.channel();

                        // _ _ _ _ _ _
                        //       P(position)
                        buffer.clear();
                        channel.read(buffer);
                        String request = new String(buffer.array());
                        buffer.clear();
                        buffer.put("HTTP/1.1 200 OK\n\nHello NIO!!\n".getBytes());
                        buffer.flip();
                        channel.write(buffer);
                        channel.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Step4Server step4Server = new Step4Server();
        step4Server.listen(8000);
    }
}
