package com.yz.jvm.common.util;

import java.io.Serializable;

/**
 * An abstraction of the system clock.
 *
 * @author John Sirois
 */
public interface Clock {

  /**
   * A clock that returns the the actual time reported by the system.
   * This clock is guaranteed to be serializable.
   */
  Clock SYSTEM_CLOCK = new SerializableClock() {
    @Override public long nowMillis() {
      return System.currentTimeMillis();
    }
    @Override public long nowNanos() {
      return System.nanoTime();
    }
    @Override public void waitFor(long millis) throws InterruptedException {
      Thread.sleep(millis);
    }
  };

  /**
   * Returns the current time in milliseconds since the epoch.
   *
   * @return The current time in milliseconds since the epoch.
   * @see System#currentTimeMillis()
   */
  long nowMillis();

  /**
   * Returns the current time in nanoseconds.  Should be used only for relative timing.
   * See {@code System.nanoTime()} for tips on using the value returned here.
   *
   * @return A measure of the current time in nanoseconds.
   * @see System#nanoTime()
   */
  long nowNanos();

  /**
   * Waits for the given amount of time to pass on this clock before returning.
   *
   * @param millis the amount of time to wait in milliseconds
   * @throws InterruptedException if this wait was interrupted
   */
  void waitFor(long millis) throws InterruptedException;
}

/**
 * A typedef to support anonymous {@link Clock} implementations that are also {@link Serializable}.
 */
interface SerializableClock extends Clock, Serializable { }
