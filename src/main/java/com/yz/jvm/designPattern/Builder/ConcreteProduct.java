package com.yz.jvm.designPattern.Builder;

public class ConcreteProduct extends Builder{
	private Product product = new Product();
	public void setPart(){
		
	}
	public Product buildProduct(){
		return product;
	}
}
