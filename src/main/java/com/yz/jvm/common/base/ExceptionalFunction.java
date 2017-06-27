package com.yz.jvm.common.base;

/**
 * An interface that captures a unit of work against an item.
 *
 * @param <S> The argument type for the function.
 * @param <T> The return type for the function.
 * @param <E> The exception type that the function throws.
 *
 * @author John Sirois
 */
public interface ExceptionalFunction<S, T, E extends Exception> {

  /**
   * Performs a unit of work on item, possibly throwing {@code E} in the process.
   *
   * <p>TODO(John Sirois): consider supporting @Nullable
   *
   * @param item The item to perform work against.
   * @return The result of the computation.
   * @throws E if there was a problem performing the work.
   */
  T apply(S item) throws E;
}
