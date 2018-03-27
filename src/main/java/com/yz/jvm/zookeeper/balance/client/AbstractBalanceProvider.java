package com.yz.jvm.zookeeper.balance.client;

import java.util.List;

public abstract class AbstractBalanceProvider<T> implements BalanceProvider<T> {
	
	protected abstract T balanceAlgorithm(List<T> items);
	protected abstract List<T> getBalanceItems();
	
	public T getBalanceItem(){
		return balanceAlgorithm(getBalanceItems());
	}

}
