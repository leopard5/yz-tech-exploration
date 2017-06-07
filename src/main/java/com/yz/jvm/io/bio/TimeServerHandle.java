package com.yz.jvm.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeServerHandle implements Runnable {

	private Socket socket;

	public TimeServerHandle(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			String currentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				System.out.println("The time server receive order :" + body);
				currentTime = "Query time order".equalsIgnoreCase(body)
						? new java.util.Date(System.currentTimeMillis())
								.toString() : "BAD ORDER";
				out.println(currentTime);
			}

		} catch (Exception e) {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (this.socket != null) {
				try {
					this.socket.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
