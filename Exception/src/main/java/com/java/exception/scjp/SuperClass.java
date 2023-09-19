package com.java.exception.scjp;

public class SuperClass {

	void method()  {
	    System.out.println("SuperClass");
	  }
}

class SubClass extends SuperClass {
	  void method() throws RuntimeException{
	    System.out.println("SubClass");
	  }
}
