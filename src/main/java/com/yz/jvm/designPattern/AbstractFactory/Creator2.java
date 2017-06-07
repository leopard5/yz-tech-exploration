package com.yz.jvm.designPattern.AbstractFactory;

public class Creator2 extends AbstractCreator{
	public AbstractProductA createProductA(){
		return new ProductA2();
	}
	public AbstractProductB createProductB(){
		return new ProductB2();
	}
}
