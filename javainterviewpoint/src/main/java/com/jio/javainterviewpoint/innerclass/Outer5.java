package com.jio.javainterviewpoint.innerclass;

public class Outer5 {
	int x = 10;
	static int y = 36;
	class Inner5 {
		int x = 20;
		public void m1() {
			int x = 30;
			System.out.println(x);
		}
	}
	public static void main(String[] args) {
		Outer5 o5 = new Outer5();
		Outer5.Inner5 i5 = o5.new Inner5();
		i5.m1();// 30
		System.out.println(o5.x);// 10
		System.out.println(i5.x);// 20
	}
}
