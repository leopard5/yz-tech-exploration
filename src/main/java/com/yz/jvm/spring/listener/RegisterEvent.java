package com.yz.jvm.spring.listener;

import org.springframework.context.ApplicationEvent;

public class RegisterEvent extends ApplicationEvent {

	public RegisterEvent(User user) {
		super(user);
	}

}
