package com.yz.jvm.spring.postprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		TestBean testBean= (TestBean)context.getBean("testBean");
		System.out.println("testBean.name=" + testBean.getName());
		System.out.println("testBean.password=" + testBean.getPassword());
	}
}
