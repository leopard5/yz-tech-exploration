package com.yz.jvm.designPattern.Decorator;

public class ConcreteDecorator2 extends Decorator {
	public ConcreteDecorator2(Component _component) {
		super(_component);
	}

	private void method2() {

	}

	public void operate() {
		super.operate();
		this.method2();
	}
}
