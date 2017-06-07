package com.yz.jvm.spring.event;

import org.springframework.context.ApplicationEvent;

public class ContentEvent extends ApplicationEvent {
	public ContentEvent(final String content) {
		super(content);
	}
}
