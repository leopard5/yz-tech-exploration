package com.yz.jvm.netty.zerocopy;

import java.io.*;
import java.net.Socket;

public class OldIOClient {
    public static void main(String[] args) throws Exception {
        Socket socket = null;

        InputStream inputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("localhost", 8899);
            String fileName = "d:/spark-2.2.0-bin-hadoop2.7.tgz";
            try {
                inputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                socket.close();
                inputStream.close();
            }

            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[4096];
            long readCount;
            long total = 0;

            long startTime = System.currentTimeMillis();

            while ((readCount = inputStream.read(buffer)) >= 0) {
                total += readCount;
                dataOutputStream.write(buffer);
            }

            System.out.println("发送总字节数： " + total + ", 耗时： " + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
            dataOutputStream.close();
            socket.close();
            inputStream.close();
        }
    }
}
