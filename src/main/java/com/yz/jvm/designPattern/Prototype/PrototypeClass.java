package com.yz.jvm.designPattern.Prototype;

import java.util.ArrayList;

public class PrototypeClass implements Cloneable {
	private ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	public PrototypeClass clone() {
		PrototypeClass prototypeClass = null;
		try {
			prototypeClass = (PrototypeClass) super.clone();
			prototypeClass.arrayList = (ArrayList<String>) this.arrayList
					.clone();
		} catch (CloneNotSupportedException e) {
		}
		return prototypeClass;
	}

	public void doSomething() {
		System.out.println("---����---");
	}
}
