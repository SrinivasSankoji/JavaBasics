package com.jio.javainterview.innerclass;

/**
 * Accessing Inner Class from Instance Area of Outer Class
 */
public class Outer3 {
	Inner3 i3 = new Inner3();

	class Inner3 {
		public void m1() {
			System.out.println("Inner Class");
		}
	}
	public static void main(String[] args) {
		Outer3 o3 = new Outer3();
		o3.i3.m1();
	}
}
