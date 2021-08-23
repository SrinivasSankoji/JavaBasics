package com.java.innerclass.material;

public class Outer4 {
	int x = 10;
	static int y = 36;
	class Inner4 {
		public void m1() {
			System.out.println(x);
			System.out.println(y);
		}
	}
	public static void main(String[] args) {
		Outer4 o4 = new Outer4();
		Outer4.Inner4 i4 = o4.new Inner4();
		i4.m1();
	}
}
