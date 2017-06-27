package com.yz.jvm.common.base;

/**
 * A closure that does not throw any checked exceptions.
 *
 * @param <T> Closure value type.
 *
 * @author John Sirois
 */
public interface Closure<T> extends ExceptionalClosure<T, RuntimeException> {
  // convenience typedef
}
