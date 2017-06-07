package com.yz.jvm.designPattern.FactoryMethod;

public class ProductFactory extends AbstractProductFactory {
	public <T extends Product> T createProduct(Class<T> c) {
		Product product = null;
		try {
			product = (Product) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("Error!!!");
		}
		return (T) product;
	}
}
