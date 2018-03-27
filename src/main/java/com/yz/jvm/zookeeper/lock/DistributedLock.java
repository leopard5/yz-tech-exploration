package com.yz.jvm.zookeeper.lock;

import java.util.concurrent.TimeUnit;

public interface DistributedLock {
	
	/*
	 * 获取锁，如果没有得到就等待
	 */
    void acquire() throws Exception;

	/*
	 * 获取锁，直到超时
	 */
    boolean acquire(long time, TimeUnit unit) throws Exception;

	/*
	 * 释放锁
	 */
    void release() throws Exception;


}
