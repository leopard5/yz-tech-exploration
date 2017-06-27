package com.yz.jvm.common.zookeeper;

import java.util.concurrent.TimeUnit;

/**
 * DistributedLock
 *
 * @author Florian Leibert
 */
public interface DistributedLock {
  void lock() throws LockingException;

  boolean tryLock(long timeout, TimeUnit unit);

  void unlock() throws LockingException;

  public static class LockingException extends RuntimeException {
    public LockingException(String msg, Exception e) {
      super(msg, e);
    }

    public LockingException(String msg) {
      super(msg);
    }
  }
}
