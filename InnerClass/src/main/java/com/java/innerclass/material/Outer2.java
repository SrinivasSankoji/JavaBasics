package com.java.innerclass.material;

public class Outer2 {
	class Inner2 {
		public void m1() {
			System.out.println("Inner Class");
		}
	}
	/**
	 * Accessing Inner Class from static Area of Outer Class
	 */
	public static void main(String[] args) {
		Outer2 o2 = new Outer2();
		Outer2.Inner2 i = o2.new Inner2();
		i.m1();
	}
}
