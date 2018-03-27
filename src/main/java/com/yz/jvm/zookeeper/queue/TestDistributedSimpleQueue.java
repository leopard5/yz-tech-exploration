package com.yz.jvm.zookeeper.queue;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

public class TestDistributedSimpleQueue {

	public static void main(String[] args) {
		
		
		ZkClient zkClient = new ZkClient("192.168.1.105:2181", 5000, 5000, new SerializableSerializer());
		DistributedSimpleQueue<User> queue = new DistributedSimpleQueue<User>(zkClient,"/Queue");
		
		User user1 = new User();
		user1.setId("1");
		user1.setName("xiao wang");
		
		User user2 = new User();
		user2.setId("2");
		user2.setName("xiao wang");		
		
		try {
			queue.offer(user1);
			queue.offer(user2);
			User u1 = queue.poll();
			User u2 = queue.poll();
			
			if (user1.getId().equals(u1.getId()) && user2.getId().equals(u2.getId())){
				System.out.println("Success!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
