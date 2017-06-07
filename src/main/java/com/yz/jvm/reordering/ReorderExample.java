package com.yz.jvm.reordering;


//写后读	a = 1;b = a;	写一个变量之后，再读这个位置
//写后写	a = 1;a = 2;	写一个变量之后，再写这个变量
//读后写	a = b;b = 1;	读一个变量之后，再写这个变量

public class ReorderExample {
	private static int a = 0;
	private static boolean flag = false;

	public void writer() {
		a = 1;       // 1
		flag = true; // 2
	}

	public void reader() {
		if (flag) {        // 3
			int i = a * a; // 4
			System.out.println("结果i=" + i);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
