package com.yz.jvm.zookeeper.lock;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.I0Itec.zkclient.ZkClient;

public class DistributedLockMutex extends BaseDistributedLock implements
		DistributedLock {
	
	//锁名称前缀
	private static final String LOCK_PREFIX = "lock-";
	//进程中的线程信息
	private final ConcurrentMap<Thread, LockData> threadData = new ConcurrentHashMap<Thread, LockData>();
		
	private final String basePath;
	
	private static class LockData
    {
        final String lockPath;
        final AtomicInteger lockCount = new AtomicInteger(1);

        private LockData(Thread owningThread, String lockPath)
        {
            this.lockPath = lockPath;
        }
    }
    
    private boolean internalLock(long time, TimeUnit unit) throws Exception
    {
        Thread currentThread = Thread.currentThread();

        LockData lockData = threadData.get(currentThread);
        if ( lockData != null )
        {
            lockData.lockCount.incrementAndGet();
            return true;
        }

        String lockPath = attemptLock(time, unit);
        if ( lockPath != null )
        {
            LockData newLockData = new LockData(currentThread, lockPath);
            threadData.put(currentThread, newLockData);
            return true;
        }

        return false;
    }
    
    public DistributedLockMutex(ZkClientExt client, String basePath){
    	    	
    	super(client,basePath,LOCK_PREFIX);
    	this.basePath = basePath;
    	
    }

	public void acquire() throws Exception {
		
        if ( !internalLock(-1, null) )
        {
            throw new IOException("连接丢失!在路径:'"+basePath+"'下不能获取锁!");
        }
	}

	public boolean acquire(long time, TimeUnit unit) throws Exception {

		return internalLock(time, unit);
	}

	public void release() throws Exception {

	    Thread currentThread = Thread.currentThread();
	    
	    LockData lockData = threadData.get(currentThread);
	    if ( lockData == null ){
	        throw new IllegalMonitorStateException("你不是锁: " + basePath + "的拥有者,无法执行此操作！");
	    }
	
	    int newLockCount = lockData.lockCount.decrementAndGet();
	    
	    if ( newLockCount > 0 ){
	        return;
	    }
	    if ( newLockCount < 0 ){
	        throw new IllegalMonitorStateException("锁计数器已经为负数: " + basePath);
	    }
	    
	    try{
	        releaseLock(lockData.lockPath);
	    }
	    finally{
	        threadData.remove(currentThread);
	    }
	}

}
