package com.yz.jvm.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("nio3.txt");
            FileChannel fileChannel = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            byte[] message = "hello world welcome".getBytes();
            for (int i = 0; i < message.length; i++) {
                byteBuffer.put(message[i]);
            }

            byteBuffer.flip();
            fileChannel.write(byteBuffer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
