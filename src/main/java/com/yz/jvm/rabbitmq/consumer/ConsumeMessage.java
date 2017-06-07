package com.yz.jvm.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ConsumeMessage implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			String receiveMsg = new String(message.getBody(), "utf-8");
			System.out.println("Receiver msg:" + receiveMsg);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
