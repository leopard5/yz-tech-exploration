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
        System.out.println("BeanInitializing");
    }

    @PostConstruct
    public void postContruct(){
        System.out.println("postContruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void initMethodTest(){
        System.out.println("initMethodTest");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("beforeDestroy");
    }

}
