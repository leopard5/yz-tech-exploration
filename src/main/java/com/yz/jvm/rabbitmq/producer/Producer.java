package com.yz.jvm.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Producer {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new GenericXmlApplicationContext("rabbitmq-producer.xml");
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		// direct模式：接收routing-key=queue_one_key的消息
		// template.convertAndSend("queue_one_key", "hello!");
		// topic模式：以foo.* routing-key为模版接收消息
		template.convertAndSend("foo.bar", "hello!");
		// fanout模式：在集群范围内的所有consumer都会收到消息
		// template.convertAndSend("hello!");
		System.out.println("send message:hello world!");
	}
}
