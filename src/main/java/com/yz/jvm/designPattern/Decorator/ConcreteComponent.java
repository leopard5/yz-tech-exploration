package com.yz.jvm.designPattern.Decorator;

public class ConcreteComponent extends Component {
	@Override
	public void operate() {
		System.out.println("---doSomething");
	}
}
