package com.java.exception.geeksforgeeks;

public class Super {
	public void method() throws RuntimeException{
	    System.out.println("SuperClass");
	  }
}
class SubClass extends Super
{
	public void method() throws ArithmeticException{
	    System.out.println("SubClass");
	  }
}
