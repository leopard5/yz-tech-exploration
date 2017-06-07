package com.yz.jvm.designPattern;

import com.yz.jvm.designPattern.Command.Command;
import com.yz.jvm.designPattern.Command.ConcreteCommand1;
import com.yz.jvm.designPattern.Command.ConcreteReciver1;
import com.yz.jvm.designPattern.Command.Invoker;
import com.yz.jvm.designPattern.Command.Receiver;
import com.yz.jvm.designPattern.Composite.Composite;
import com.yz.jvm.designPattern.Composite.Leaf;
import com.yz.jvm.designPattern.Decorator.Component;
import com.yz.jvm.designPattern.Decorator.ConcreteComponent;
import com.yz.jvm.designPattern.Decorator.ConcreteDecorator1;
import com.yz.jvm.designPattern.Decorator.ConcreteDecorator2;
import com.yz.jvm.designPattern.FactoryMethod.ProductA;
import com.yz.jvm.designPattern.FactoryMethod.ProductFactory;
import com.yz.jvm.designPattern.Memento.Caretaker;
import com.yz.jvm.designPattern.Memento.Originator;
import com.yz.jvm.designPattern.Observer.ConcreteObserver;
import com.yz.jvm.designPattern.Observer.ConcreteSubject;
import com.yz.jvm.designPattern.Observer.Observer;
import com.yz.jvm.designPattern.Prototype.PrototypeClass;
import com.yz.jvm.designPattern.Proxy.Proxy;
import com.yz.jvm.designPattern.Proxy.Subject;
import com.yz.jvm.designPattern.Strategy.ConcreteStrategy1;
import com.yz.jvm.designPattern.Strategy.Context;
import com.yz.jvm.designPattern.Strategy.Strategy;
import com.yz.jvm.designPattern.TemplateMethod.AbstractClass;
import com.yz.jvm.designPattern.TemplateMethod.ConcreteClass1;
import com.yz.jvm.designPattern.TemplateMethod.ConcreteClass2;

public class TestDesignPatterns {
	public static void main(String[] args) {
		// 工厂模式
		//factoryMethodPractice();

	}

	private static void factoryMethodPractice() {
//		ProductFactory productFactory = new ProductFactory();
//		FactoryMethod.Product pro = productFactory
//				.createProduct(ProductA.class);
//		pro.getProductInfo();
	}

	public static void mementoPractice() {
		// Memento 备忘录模式
		// 定义出发起人
		Originator originator = new Originator();
		// 定义出备忘录管理员
		Caretaker caretaker = new Caretaker();
		// 创建一个备忘录
		caretaker.setMemento(originator.createMemento());
		// 恢复一个备忘录
		originator.restoreMemento(caretaker.getMemento());
	}

	public static void DeadLockPractice() {
		/**
		 * 死锁形成的四个条件：
		 * 1. 互斥（Mutual exclusion）：存在这样一种资源，它在某个时刻只能被分配给一个执行绪（也称为线程）使用； 
		 * 2. 持有（Hold and wait）：当请求的资源已被占用从而导致执行绪阻塞时，资源占用
		 *    者不但无需释放该资源，而且还可以继续请求更多资源；
		 * 3. 不可剥夺（No preemption）：执行绪获得到的互斥资源不可被强行剥夺，换句话说， 只有资源占用者自己才
		 *    能释放资源；
		 * 4. 环形等待（Circular wait）：若干执行绪以不同的次序获取互斥资源，从而形成环
		 *    形等待的局面，想象在由多个执行绪组成的环形链中，每个执行绪都在等待下一个执行绪 释放它持有的资源。
		 **/

		// 避免死锁的办法
		/**
		 * 1. 避免嵌套封锁 当几个线程都要访问共享资源A、B、C时，保证使每个线程都按照同样的顺序去 访问它们，比如都先访问A，在访问B和C 
		 * 2. 只对有请求的进行封锁 
		 * 3. 避免无限期的等待,设置死锁超时参数为合理范围，如：3分钟-10分种；
		 *    超过时间，自动放弃本次操作，避免进程悬挂；
		 * 4. 死锁检测 
		 * 5. 使用银行家算法
		 */
	}

	private static void templateMethodPractice() {
		// TemplateMethod
		AbstractClass class1 = new ConcreteClass1();
		AbstractClass class2 = new ConcreteClass2();
		// 调用模板方法
		class1.templateMethod();
		class2.templateMethod();
	}

	private static void ProxyPractice() {
		// Proxy
		Subject sub = new Proxy();
		sub.request();
	}

	private static void prototypePractice() {
		// 原型模式(Prototype Pattern)
		// 如果PrototypeClass内部有非基本类型的成员变量，需要注意浅拷贝 和深拷贝的问题
		// 一般都需要深拷贝 ，此时需要在PrototypeClass类clone()方法
		// 中对非基本类型也执行clone方法
		PrototypeClass proclass = new PrototypeClass();
		for (int i = 0; i < 5; i++) {
			PrototypeClass proclassclone = proclass.clone();
			proclassclone.doSomething();
		}
	}

	private static void commandPractice() {
		// Command 命令模式
		// 首先声明调用者Invoker
		Invoker invoker = new Invoker();
		// 定义接收者
		Receiver receiver = new ConcreteReciver1();
		// 定义一个发送给接收者的命令
		Command command = new ConcreteCommand1(receiver);
		// 把命令交给调用者去执行
		invoker.setCommand(command);
		invoker.action();
	}

	private static void decoratorPractice() {
		// Decorator 装饰着模式
		Component component = new ConcreteComponent();
		// 第一次修饰
		component = new ConcreteDecorator1(component);
		// 第二次修饰
		component = new ConcreteDecorator2(component);
		// 修饰后运行
		component.operate();
	}

	private static void strategyPractice() {
		// Strategy 策略模式
		// 声明一个具体的策略
		Strategy strategy = new ConcreteStrategy1();
		// 声明上下文对象
		Context context = new Context(strategy);
		// 执行封装后的方法
		context.doAnythinig();
	}

	private static void compositePractice() {
		// Composite 组合模式
		// 创建一个根节点
		Composite root = new Composite();
		root.doSomething();
		// 创建一个树枝构件
		Composite branch = new Composite();
		// 创建一个叶子节点
		Leaf leaf = new Leaf();
		// 建立整体
		root.add(branch);
		branch.add(leaf);
	}

	private static void observerPractice() {
		// 观察者模式
		// 创建一个被观察者
		ConcreteSubject subject = new ConcreteSubject();
		// 定义一个观察者
		Observer obs = new ConcreteObserver();
		// 观察者观察被观察者
		subject.addObserver(obs);
		// 观察者开始活动了
		subject.doSomething();
	}
}
