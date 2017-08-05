package com.yz.jvm.rabbitmq.event;

import java.io.Serializable;

public class EventMessage implements Serializable {

	private static final long serialVersionUID = 6742149452746213290L;

	private String recipients;
	private Class<?> clazz;
	private String attachment;

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public String toString() {
		return "EventMessage [recipients=" + recipients + ", clazz=" + clazz
				+ ", attachment=" + attachment + "]";
	}

}
