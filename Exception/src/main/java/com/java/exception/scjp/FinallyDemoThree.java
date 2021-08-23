package com.java.exception.scjp;

public class FinallyDemoThree {
	public static void main(String[] args) {
		System.out.println(10/0);
		try {
			System.out.println("Try Block");
		}
		catch (Exception e) {
			System.out.println("Catch Block");
		}
		finally {
			System.out.println("Finally Block");
		}
	}
}
