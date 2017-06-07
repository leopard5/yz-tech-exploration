package com.yz.jvm.curator.demo.queue;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.queue.QueueConsumer;
import org.apache.curator.framework.state.ConnectionState;

public class StringConsumerHanlder implements QueueConsumer<String> {

	public void stateChanged(CuratorFramework client, ConnectionState newState) {
		System.out.println("当前状态=" + newState.name());
		System.out.println("当前data=" + client.getData());
	}

	public void consumeMessage(String message) throws Exception {
		System.out.println("消息被消费了，消息内容=" + message);
	}

}
