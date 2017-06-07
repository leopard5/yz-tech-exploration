package com.yz.jvm.rabbitmq.converter;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import com.alibaba.fastjson.JSON;

public class FastJsonMessageConverter extends AbstractMessageConverter {
	private static Log log = LogFactory.getLog(FastJsonMessageConverter.class);

	public static final String DEFAULT_CHARSET = "UTF-8";

	private volatile String defaultCharset = DEFAULT_CHARSET;

	public FastJsonMessageConverter() {
		super();
		// init();
	}

	public void setDefaultCharset(String defaultCharset) {
		this.defaultCharset = (defaultCharset != null) ? defaultCharset
				: DEFAULT_CHARSET;
	}

	public Object fromMessage(Message message)
			throws MessageConversionException {
		return null;
	}

	public <T> T fromMessage(Message message, T t) {
		String json = "";
		try {
			json = new String(message.getBody(), defaultCharset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return (T) JSON.parseObject(json, t.getClass());
	}

	protected Message createMessage(Object objectToConvert,
			MessageProperties messageProperties)
			throws MessageConversionException {
		byte[] bytes = null;
		try {
			String jsonString = JSON.toJSONString(objectToConvert);
			// FastJson.toJson(objectToConvert);
			bytes = jsonString.getBytes(this.defaultCharset);
		} catch (UnsupportedEncodingException e) {
			throw new MessageConversionException(
					"Failed to convert Message content", e);
		}
		messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
		messageProperties.setContentEncoding(this.defaultCharset);
		if (bytes != null) {
			messageProperties.setContentLength(bytes.length);
		}
		return new Message(bytes, messageProperties);

	}
}
