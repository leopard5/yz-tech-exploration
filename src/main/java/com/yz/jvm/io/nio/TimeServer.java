package com.yz.jvm.io.nio;

public class TimeServer {
	public static void main(String[] args) {
		int port = 8080;
		MutiplexerTimeServer timeServer = new MutiplexerTimeServer(port);
		new Thread(timeServer, "NIO-MutiplexerTimeServer=001").start();
	}
}
