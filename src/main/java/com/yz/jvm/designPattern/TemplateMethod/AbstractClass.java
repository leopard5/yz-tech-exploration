package com.yz.jvm.designPattern.TemplateMethod;

public abstract class AbstractClass {
	protected abstract void doSomething();
	protected abstract void doAnything();
	
	public void templateMethod(){
		this.doSomething();
		this.doAnything();
	}
}
