package com.yz.jvm.common.base;

/**
 * A convenience typedef for suppliers that throw multiple exception types.
 *
 * @param <T> The supplied type.
 *
 * @author John Sirois
 */
public interface SupplierE<T> extends ExceptionalSupplier<T, Exception> {
  // typedef
}
