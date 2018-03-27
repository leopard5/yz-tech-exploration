package com.yz.jvm.zookeeper.queue;

import java.io.Serializable;

public class User implements Serializable {
	
	String name;
	String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
