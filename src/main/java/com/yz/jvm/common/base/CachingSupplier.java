package com.yz.jvm.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.yz.jvm.common.quantity.Amount;
import com.yz.jvm.common.quantity.Time;
import com.yz.jvm.common.util.Clock;


/**
 * A supplier that caches responses from an underling supplier, expiring the cached value after
 * a fixed expiration time.
 *
 * @param <T> Supplied value type.
 *
 * @author William Farner
 */
public class CachingSupplier<T> implements Supplier<T> {

  private final Supplier<T> wrapped;
  private final long expirationNanos;
  private final Clock clock;

  private long lastFetchNanos = -1;
  private T cachedValue;

  /**
   * Creates a new caching supplier.
   *
   * @param wrapped The supplier to delegate fetches to.
   * @param expiration The maximum amount of time that a response from {@code supplier} will be
   *   cached for.  The expiration must be positive.
   */
  public CachingSupplier(Supplier<T> wrapped, Amount<Long, Time> expiration) {
    this(wrapped, expiration, Clock.SYSTEM_CLOCK);
  }

  @VisibleForTesting
  CachingSupplier(Supplier<T> wrapped, Amount<Long, Time> expiration, Clock clock) {
    this.wrapped = Preconditions.checkNotNull(wrapped);
    this.expirationNanos = Preconditions.checkNotNull(expiration).as(Time.NANOSECONDS);
    Preconditions.checkArgument(expiration.getValue() > 0, "Expiration must be positive.");
    this.clock = Preconditions.checkNotNull(clock);
  }

  @Override
  public synchronized T get() {
    if ((lastFetchNanos == -1) || (clock.nowNanos() - lastFetchNanos > expirationNanos)) {
      cachedValue = wrapped.get();
      lastFetchNanos = clock.nowNanos();
    }

    return cachedValue;
  }
}
