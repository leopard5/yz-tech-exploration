package com.yz.jvm.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 执行顺序
 * 1. InitSequenceBean: constructor
 * 2. InitSequenceBean: postConstruct
 * 3. InitSequenceBean: afterPropertiesSet
 * 4. InitSequenceBean: init-method
 *
 * 1. PreDestroy
 * 2. DisposableBean
 */
public class BeanInitializing implements InitializingBean, DisposableBean {

    private static String password = "";

    public BeanInitializing() {
        System.out.println("BeanInitializing constructer");
    }

    @PostConstruct
    public void postContruct(){
        System.out.println("PostConstruct annotation");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet");
    }

    public void initMethodTest(){
        System.out.println("xml config initMethodTest");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("PreDestroy annotation");
    }

}
