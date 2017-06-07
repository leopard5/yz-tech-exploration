package com.yz.jvm.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class PostFactoryBean implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //BeanFactoryPostProcessor可以修改BEAN的配置信息而BeanPostProcessor不能 
        //我们在这里修改postProcessorBean的username注入属性  
        BeanDefinition bd = beanFactory.getBeanDefinition("testBean");
        MutablePropertyValues pv =  bd.getPropertyValues();  
        if(pv.contains("name"))  
        {
            pv.addPropertyValue("name", "xiaojun");
        } 
		System.out.println("postProcessBeanFactory call!");
	}

}
