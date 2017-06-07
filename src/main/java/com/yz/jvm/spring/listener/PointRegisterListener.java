package com.yz.jvm.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PointRegisterListener
		implements
			ApplicationListener<RegisterEvent> {
	@Async
	public void onApplicationEvent(final RegisterEvent event) {
		System.out.println("注册成功，赠送积分给："
				+ ((User) event.getSource()).getUsername());
	}
}
