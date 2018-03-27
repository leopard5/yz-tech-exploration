package com.yz.jvm.zookeeper.balance.client;

import java.util.List;

public interface BalanceProvider<T> {
	
	T getBalanceItem();
	

}
