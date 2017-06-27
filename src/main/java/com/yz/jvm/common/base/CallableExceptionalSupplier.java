package com.yz.jvm.common.base;

import java.util.concurrent.Callable;

/**
 * A supplier that may also be called.
 *
 * @param <T> The supplier type.
 * @param <E> Supplier exception type.
 *
 * @author John Sirois
 */
public abstract class CallableExceptionalSupplier<T, E extends Exception>
    implements ExceptionalSupplier<T, E>, Callable<T> {

  @Override public T call() throws Exception {
    return get();
  }
}
