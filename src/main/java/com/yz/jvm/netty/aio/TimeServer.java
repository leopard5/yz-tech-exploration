package com.yz.jvm.netty.aio;

import java.io.IOException;

public class TimeServer {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
