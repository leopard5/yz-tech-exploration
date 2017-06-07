package com.yz.jvm.bytecode;

/**
 * @CopyRright (c)2015-2017: <My Company>
 * @Project: <study>
 * @Comments: <MyClassLoader>
 * @JDK 1.7
 * @Author: <yazhong.qi>
 * @email : <qiyazhong@163.com>
 * @Create Date: <2016-12-20>
 * @Modify Date: <2016-12-20>
 * @Version: <1.0>
 */
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
