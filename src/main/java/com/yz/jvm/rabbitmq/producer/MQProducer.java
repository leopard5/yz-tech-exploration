package com.yz.jvm.rabbitmq.producer;

import com.alibaba.fastjson.JSONObject;
import com.yz.jvm.rabbitmq.event.EventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

import java.util.UUID;

public class MQProducer {
    private static Logger logger = LoggerFactory.getLogger(MQProducer.class);

    private RabbitTemplate rabbitTemplate;

    public MQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public <T> void sendDataToQueue(String routingKey, String recipients, T attachment) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        EventMessage message = new EventMessage();
        message.setRecipients(recipients);
        message.setClazz(attachment.getClass());
        String attachmentString = JSONObject.toJSONString(attachment);
        message.setAttachment(attachmentString);
        rabbitTemplate.convertAndSend(routingKey, message, correlationId);
    }

}
