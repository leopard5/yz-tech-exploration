package com.yz.jvm.designPattern.Proxy;

public class Proxy implements Subject {
	private Subject subject = null;

	public Proxy() {
		this.subject = new RealSubject();
	}

	public Proxy(Subject _subject) {
		this.subject = _subject;
	}

	public void request() {
		if (null == subject) {
			subject = new RealSubject();
		}
		this.before();
		this.subject.request();
		this.after();
	}

	public void before() {
		System.out.println("---before---");
	}

	public void after() {
		System.out.println("---after---");
	}

}
