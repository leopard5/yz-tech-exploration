package com.yz.jvm.zookeeper.balance.server;

public interface BalanceUpdateProvider {
	
	boolean addBalance(Integer step);
	
	boolean reduceBalance(Integer step);

}
