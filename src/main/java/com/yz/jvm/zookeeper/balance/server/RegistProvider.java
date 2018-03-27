package com.yz.jvm.zookeeper.balance.server;

public interface RegistProvider {
	
	void regist(Object context) throws Exception;
	
	void unRegist(Object context) throws Exception;

}
