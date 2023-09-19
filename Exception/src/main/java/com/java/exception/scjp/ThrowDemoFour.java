package com.java.exception.scjp;

public class ThrowDemoFour {
	static ArithmeticException exception=new ArithmeticException();
	public static void main(String[] args) {
		throw exception; // Runtime Exception
	}
}
