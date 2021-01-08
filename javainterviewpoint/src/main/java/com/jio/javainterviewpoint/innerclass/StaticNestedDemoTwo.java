package com.jio.javainterviewpoint.innerclass;

public class StaticNestedDemoTwo {
	static class Inner {
		public static void main(String[] args) {
			System.out.println("Ststic Inner Class Main Method");
		}
	}
	public static void main(String[] args) {
		System.out.println("Main Method");
	}
}
