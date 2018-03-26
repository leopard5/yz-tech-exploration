package com.yz.jvm.zookeeper.testzkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class WriteData {

	public static void main(String[] args) {
		ZkClient zc = new ZkClient("192.168.1.105:2181",10000,10000,new SerializableSerializer());
		System.out.println("conneted ok!");
		
		
		User u = new User();
		u.setId(2);
		u.setName("test2");
		zc.writeData("/jike5", u, 1);
		
	}
	
}
