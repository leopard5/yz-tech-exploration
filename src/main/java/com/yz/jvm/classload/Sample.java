package com.yz.jvm.classload;

public class Sample {
	public static void main(String[] args) {
		System.out.println("---------路径 start---------");
		System.out.println(System.getProperty("sun.boot.class.path"));
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("java.class.path"));
		System.out.println();
		System.out.println("---------路径 end---------");
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(contextClassLoader);
		
		ClassLoader cloader;
		cloader = ClassLoader.getSystemClassLoader();
		System.out.println(cloader);
		while (cloader != null) {
			cloader = cloader.getParent();
			System.out.println(cloader);
		}
		try {
			Class<Object> c1 = (Class<Object>) Class.forName("java.lang.Object");
			cloader = c1.getClassLoader();
			System.out.println("java.lang.Object's loader is " + cloader);
			Class<Sample> c2 = (Class<Sample>) Class.forName("com.yz.study.classload.Sample");
			cloader = c2.getClassLoader();
			System.out.println("Sample's loader is " + cloader);
			
			Class<Object> class1 = (Class<Object>)Class.forName("com.yz.study.classload.Sample");
			Sample object = (Sample) class1.newInstance();
			System.out.println("testAdd=" + object.testAdd());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int testAdd(){
		return 1+2;
	}
}
