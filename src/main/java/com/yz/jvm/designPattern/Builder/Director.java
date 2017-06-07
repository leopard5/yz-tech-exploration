package com.yz.jvm.designPattern.Builder;

public class Director {
	private Builder builder = new ConcreteProduct();
	public Product getAProduct(){
		this.builder.setPart();
		return this.builder.buildProduct();
	}
}
