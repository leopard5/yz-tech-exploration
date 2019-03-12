package com.yz.jvm.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        int orderNum = 1;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                out.println("QUERY TIME ORDER [" + orderNum + "]");
                System.out.println("Send order " + orderNum + " server succeed.");
                String resp = in.readLine();
                System.out.println("Now is : " + resp);
                orderNum++;
                Thread.sleep(3000);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("time server is shutdown!!!");
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
