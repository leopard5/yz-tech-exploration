package com.yz.jvm.rabbitmq.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Cosumer {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext(
				"rabbitmq-consumer.xml");
	}
}
