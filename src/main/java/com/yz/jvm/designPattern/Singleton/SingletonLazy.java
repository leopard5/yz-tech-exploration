package com.yz.jvm.designPattern.Singleton;

/**
 * 懒汉式单例
 * 
 * @author qiyazhong
 *
 */
public class SingletonLazy {
	private volatile static SingletonLazy singlotonp = null;

	// 私有构造函数
	private SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		// 第一重判断
		if (null == singlotonp) {
			// 锁定代码块
			synchronized (SingletonLazy.class) {
				// 第二重判断
				if (null == singlotonp) {
					// 创建单例实例
					singlotonp = new SingletonLazy();
				}
			}
		}
		return singlotonp;
	}
}
