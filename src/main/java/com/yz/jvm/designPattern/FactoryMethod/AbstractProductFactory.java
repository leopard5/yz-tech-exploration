package com.yz.jvm.designPattern.FactoryMethod;

public abstract class AbstractProductFactory {
	public abstract <T extends Product>T createProduct(Class<T> c);
}
