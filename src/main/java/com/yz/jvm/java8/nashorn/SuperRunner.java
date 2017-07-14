package com.yz.jvm.java8.nashorn;

/**
 * @author Benjamin Winterberg
 */
public class SuperRunner implements Runnable {

    @Override
    public void run() {
        System.out.println("super run");
    }

}