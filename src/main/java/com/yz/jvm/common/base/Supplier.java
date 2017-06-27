package com.yz.jvm.common.base;

/**
 * A convenience typedef that also ties into google's {@code Supplier}.
 *
 * @param <T> The supplied type.
 *
 * @author John Sirois
 */
public interface Supplier<T>
    extends ExceptionalSupplier<T, RuntimeException>, com.google.common.base.Supplier<T> {

  @Override
  T get();
}
