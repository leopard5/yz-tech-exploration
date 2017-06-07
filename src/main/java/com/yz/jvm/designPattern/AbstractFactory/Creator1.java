package com.yz.jvm.designPattern.AbstractFactory;

public class Creator1 extends AbstractCreator{
	public AbstractProductA createProductA(){
		return new ProductA1();
	}
	public AbstractProductB createProductB(){
		return new ProductB1();
	}
}
