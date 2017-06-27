package com.yz.jvm.common.base;

/**
 * A command that does not throw any checked exceptions.
 *
 * @author John Sirois
 */
public interface Command extends ExceptionalCommand<RuntimeException> {
  // convenience typedef
}
