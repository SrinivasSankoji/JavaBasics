package com.jio.javainterview.innerclass;

public class StaticNestedDemoOne {
	static class Inner {
		public void m1() {
			System.out.println("Static Nested Class");
		}
	}
	public static void main(String[] args) {
		Inner demo = new StaticNestedDemoOne.Inner();
		demo.m1();
	}
}
