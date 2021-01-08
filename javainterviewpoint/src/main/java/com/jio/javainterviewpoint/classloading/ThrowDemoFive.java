package com.jio.javainterviewpoint.classloading;

public class ThrowDemoFive {
	static ArithmeticException exception;
	public static void main(String[] args) {
		throw exception;
	}
}
