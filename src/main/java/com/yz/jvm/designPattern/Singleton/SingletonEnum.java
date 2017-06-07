package com.yz.jvm.designPattern.Singleton;

/**
 *
 * 1.从Java1.5开始支持; 
 * 2.无偿提供序列化机制; 
 * 3.绝对防止多次实例化，即使在面对复杂的序列化或者反射攻击的时候;
 *
 * @author qiyazhong
 *
 */
public enum SingletonEnum {
	INSTANCE;

	public SingletonEnum getInstance() {
		// 增加这个方法是让别人明白怎么使用，因为这种实现方式
		// 还比较少见，限于java 1.5之后的版本
		return INSTANCE;
	}

	public void print() {
		System.out.println("hello,world");
	}
}
