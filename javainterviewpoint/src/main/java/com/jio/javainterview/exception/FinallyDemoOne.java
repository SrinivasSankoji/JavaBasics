package com.jio.javainterview.exception;

public class FinallyDemoOne {
	public static void main(String[] args) {
		try {
			System.out.println("Try");
			System.out.println(10/0);
		}
		catch (Exception e) {
			System.out.println("Catch");
		}
		finally {
			System.out.println("Finally");
		}
	}
}
