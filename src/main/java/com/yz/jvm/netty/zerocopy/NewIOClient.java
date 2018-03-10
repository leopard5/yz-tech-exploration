package com.yz.jvm.netty.zerocopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = null;
        FileChannel fileChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8899));
            socketChannel.configureBlocking(true);

            String fileName = "d:/spark-2.2.0-bin-hadoop2.7.tgz";

            try {
                fileChannel = new FileInputStream(fileName).getChannel();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            long startTime = System.currentTimeMillis();

            long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

            System.out.println("发送总字节数：" + transferCount + "，耗时： " + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketChannel.close();
            fileChannel.close();
        }

    }
}
