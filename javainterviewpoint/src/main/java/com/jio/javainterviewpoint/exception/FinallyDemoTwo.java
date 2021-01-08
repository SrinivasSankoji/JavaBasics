package com.jio.javainterviewpoint.exception;

public class FinallyDemoTwo {
	public static void main(String[] args) {
		try {
			System.out.println("Try");
			System.exit(0);
			return;
		}
		catch (Exception e) {
			System.out.println("Catch");
		}
		finally {
			System.out.println("Finally");
		}
	}
}
