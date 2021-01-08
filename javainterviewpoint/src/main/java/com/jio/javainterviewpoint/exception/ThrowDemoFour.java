package com.jio.javainterviewpoint.exception;

public class ThrowDemoFour {
	static ArithmeticException exception=new ArithmeticException();
	public static void main(String[] args) {
		throw exception;
	}
}
