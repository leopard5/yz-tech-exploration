package com.yz.jvm.netty.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {
    public static Boolean flag = null;

    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = null;

        try {
            serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(address);

            ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

            while (true) {
                if (flag != null) {
                    break;
                }
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(true);
                int readCount = 0;
                while (-1 != readCount) {
                    try {
                        readCount = socketChannel.read(byteBuffer);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    byteBuffer.rewind();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocketChannel.close();
        }
    }
}
