package com.yz.jvm.designPattern.Command;

public class ConcreteCommand2 extends Command {
	private Receiver receiver = null;

	public void ConcreteCommand2(Receiver _receiver) {
		this.receiver = _receiver;
	}

	public void execute() {
		this.receiver.doSomething();
	}
}
