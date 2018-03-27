package com.yz.jvm.zookeeper.balance.server;

import java.io.Serializable;

public class ServerData implements Serializable,Comparable<ServerData> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8892569870391530906L;
	
	
	private Integer balance;
	private String host;
	private Integer port;
	
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
	@Override
	public String toString() {
		return "ServerData [balance=" + balance + ", host=" + host + ", port="
				+ port + "]";
	}
	public int compareTo(ServerData o) {
		// TODO Auto-generated method stub
		return this.getBalance().compareTo(o.getBalance());
	}
	
	

}
