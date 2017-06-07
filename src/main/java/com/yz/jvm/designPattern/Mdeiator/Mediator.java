package com.yz.jvm.designPattern.Mdeiator;

public abstract class Mediator {
	protected ConcreteColleague1 c1;
	protected ConcreteColleague2 c2;

	/**
	 * @return the c1
	 */
	public ConcreteColleague1 getC1() {
		return c1;
	}

	/**
	 * @param c1
	 *            the c1 to set
	 */
	public void setC1(ConcreteColleague1 c1) {
		this.c1 = c1;
	}

	/**
	 * @return the c2
	 */
	public ConcreteColleague2 getC2() {
		return c2;
	}

	/**
	 * @param c2
	 *            the c2 to set
	 */
	public void setC2(ConcreteColleague2 c2) {
		this.c2 = c2;
	}

	// 中介者模式的业务逻辑
	public abstract void doSomething1();

	public abstract void doSomething2();
}
