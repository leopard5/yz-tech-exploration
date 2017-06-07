package com.yz.jvm.designPattern.Singleton;

/**
 * 饿汉式单例类
 * 
 * @author qiyazhong 
 * 单例模式有三个要点：
 * 一是某个类只能有一个实例
 * 二是它必须自行创建这个实例
 * 三是它必须 自行向整个系统提供这个实例
 */
public class Singleton {
	private static final Singleton SINGLETON = new Singleton();

	// 私有构造函数
	// 禁止类的外部直接使用new来创建对象，因此需要将SingltonClass的构造函数的可见性改为
	private Singleton() {
	}

	// 需要注意的是getInstance()方法的修饰符，首先应该是一个public方法，以便
	// 供外界其他对象使用，其次它使用了static关键字，即它是一个静态方法，在类外
	// 可以直接通过类名来访问，而无须创建Singleton对象，事实上在类外也无法
	// 创建Singleton对象，因为构造函数是私有的
	public static Singleton getInstance() {
		return SINGLETON;
	}
}
