package com.yz.jvm.netty.nio;

import java.io.IOException;

public class TimeServer {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
