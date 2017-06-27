package com.yz.jvm.common.base;

/**
 * A convenience typedef that also ties into google's {@code Function}.
 *
 * @param <S> The argument type for the function.
 * @param <T> The return type for the function.
 *
 * @author John Sirois
 */
public interface Function<S, T>
    extends ExceptionalFunction<S, T, RuntimeException>, com.google.common.base.Function<S, T> {

  @Override
  T apply(S item);
}
