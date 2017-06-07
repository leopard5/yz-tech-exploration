package com.yz.jvm.designPattern.Command;

public class ConcreteCommand1 extends Command {
	private Receiver receiver = null;

	public ConcreteCommand1(Receiver _receiver) {
		this.receiver = _receiver;
	}

	public void execute() {
		this.receiver.doSomething();
	}
}
