package com.yz.jvm.zookeeper.balance.client;

public interface Client {

	void connect() throws Exception;
	void disConnect() throws Exception;
	
}
