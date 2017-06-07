package com.yz.jvm.spring.aware;

import org.springframework.beans.factory.BeanNameAware;

public class LoggingBean implements BeanNameAware{

	private String beanName;
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

}
