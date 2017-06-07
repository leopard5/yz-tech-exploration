package com.yz.jvm.designPattern.Proxy;

public class RealSubject implements Subject {
	public void request() {
		System.out.println("---ʵ�������ҵ���߼�---");
	}
}