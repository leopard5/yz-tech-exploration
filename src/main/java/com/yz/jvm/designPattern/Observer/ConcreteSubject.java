package com.yz.jvm.designPattern.Observer;

public class ConcreteSubject extends SubjectObject {
	public void doSomething() {
		// to do
		super.notifyObservers();
	}
}
