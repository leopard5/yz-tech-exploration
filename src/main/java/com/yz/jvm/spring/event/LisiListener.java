package com.yz.jvm.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LisiListener implements ApplicationListener<ApplicationEvent> {

	public void onApplicationEvent(final ApplicationEvent event) {
		if (event instanceof ContentEvent) {
			System.out.println("李四收到了新的内容：" + event.getSource());
		}
	}
}
