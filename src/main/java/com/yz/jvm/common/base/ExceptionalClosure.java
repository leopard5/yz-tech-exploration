package com.yz.jvm.common.base;

/**
 * An interface that captures a unit of work against an item.
 *
 * @param <T> The closure type.
 * @param <E> The exception type thrown by the closure.
 *
 * @author John Sirois
 */
public interface ExceptionalClosure<T, E extends Exception> {

  /**
   * Performs a unit of work on item, possibly throwing {@code E} in the process.
   *
   * <p>TODO(John Sirois): consider supporting @Nullable
   *
   * @param item the item to perform work against
   * @throws E if there was a problem performing the work
   */
  void execute(T item) throws E;
}
