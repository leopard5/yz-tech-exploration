package com.yz.jvm.netty.nio;

public class TimeClient {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int port = 8080;
        new Thread(
                new TimeClientHandle("127.0.0.1", port),
                "TimeClient-001")
                .start();
    }
}
