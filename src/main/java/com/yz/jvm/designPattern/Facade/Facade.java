package com.yz.jvm.designPattern.Facade;

public class Facade {
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();

	public void methodA() {
		this.a.doSomethingA();
	}

	public void methodB() {
		this.b.doSomethingB();
	}
}
