package com.yz.jvm.bytecode;

public class MyClassLoader extends ClassLoader {
	
	/**
	 * defineMyClass
	 * @param b
	 * @param off
	 * @param len
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Class<?> defineMyClass(byte[] b, int off, int len) {
		return super.defineClass(b, off, len);
	}
}
