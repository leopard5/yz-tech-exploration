package com.yz.jvm.common.base;

/**
 * An interface that captures a source of data.
 *
 * @param <T> The supplied value type.
 * @param <E> The type of exception that the supplier throws.
 *
 * @author John Sirois
 */
public interface ExceptionalSupplier<T, E extends Exception> {

  /**
   * Supplies an item, possibly throwing {@code E} in the process of obtaining the item.
   *
   * @return the result of the computation
   * @throws E if there was a problem performing the work
   */
  T get() throws E;
}
