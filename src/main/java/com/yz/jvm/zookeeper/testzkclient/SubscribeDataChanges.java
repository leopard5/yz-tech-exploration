package com.yz.jvm.zookeeper.testzkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class SubscribeDataChanges {
	
	private static class ZkDataListener implements IZkDataListener{

		public void handleDataChange(String dataPath, Object data) {
			// TODO Auto-generated method stub
			System.out.println(dataPath+":"+data.toString());
		}

		public void handleDataDeleted(String dataPath) {
			// TODO Auto-generated method stub
			System.out.println(dataPath);
			
		}

		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		ZkClient zc = new ZkClient("192.168.1.105:2181",10000,10000,new BytesPushThroughSerializer());
		System.out.println("conneted ok!");
		
		zc.subscribeDataChanges("/jike20", new ZkDataListener());
		Thread.sleep(Integer.MAX_VALUE);
		
		
	}
	
}
