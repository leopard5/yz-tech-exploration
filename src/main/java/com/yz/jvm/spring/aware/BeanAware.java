package com.yz.jvm.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware{
    private String                     beanName;
    private ApplicationContext        applicationContext;
    private BeanFactory                beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("beanFactory fetch");
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
        System.out.println("beanName fetch");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("application fetch");
    }
}
