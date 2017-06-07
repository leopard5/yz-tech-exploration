package com.yz.jvm.designPattern.Strategy;

public class Context {
	// 抽象策略
	private Strategy strategy = null;

	public Context(Strategy _strategy) {
		this.strategy = _strategy;
	}

	// 封装后的策略方法
	public void doAnythinig() {
		this.strategy.doSomething();
	}
}
