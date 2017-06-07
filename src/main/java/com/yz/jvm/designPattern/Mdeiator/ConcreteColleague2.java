package com.yz.jvm.designPattern.Mdeiator;

public class ConcreteColleague2 extends Colleague {
	public ConcreteColleague2(Mediator _mediator) {
		super(_mediator);
	}

	// 自有方法self-method
	public void selfMethod2() {
		// 处理自己的业务逻辑
	}

	// 依赖方法dep-method
	public void depMethod2() {
		// 处理自己的业务逻辑
		// 自己不能处理的业务逻辑，委托给中介者处理
		super.mediator.doSomething2();
	}
}
