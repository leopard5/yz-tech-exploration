package com.yz.jvm.common.base;

/**
 * An interface that captures a unit of work.
 *
 * @param <E> The type of exception that the command throws.
 *
 * @author John Sirois
 */
public interface ExceptionalCommand<E extends Exception> {

  /**
   * Performs a unit of work, possibly throwing {@code E} in the process.
   *
   * @throws E if there was a problem performing the work
   */
  void execute() throws E;
}
