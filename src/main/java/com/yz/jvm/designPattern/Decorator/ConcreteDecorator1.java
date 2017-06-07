package com.yz.jvm.designPattern.Decorator;

public class ConcreteDecorator1 extends Decorator {
	public ConcreteDecorator1(Component _component) {
		super(_component);
	}

	private void method1() {
		System.out.println("method1����");
	}

	public void operate() {
		this.method1();
		super.operate();
	}
}
