package com.yz.jvm.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EpollClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 5000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();

//            while (true) {
//                writeBuffer.rewind();
//                socketChannel.write(writeBuffer);
//                readBuffer.clear();
//                socketChannel.read(readBuffer);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
