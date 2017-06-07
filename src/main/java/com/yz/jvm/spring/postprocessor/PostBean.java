package com.yz.jvm.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostBean implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof TestBean) {
			TestBean testBean = (TestBean)bean;
			System.out.println(testBean.getPassword());
			testBean.setPassword("1233");
			System.out.println(testBean.getPassword());
		}
		System.out.println("postProcessBeforeInitialization call!");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof TestBean) {
			TestBean testBean = (TestBean)bean;
			System.out.println(testBean.getPassword());
		}
		System.out.println("postProcessAfterInitialization call!");
		return bean;
	}

}
