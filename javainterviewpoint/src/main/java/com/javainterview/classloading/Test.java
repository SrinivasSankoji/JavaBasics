package com.javainterview.classloading;

public class Test {

	//Static Block
	static {
		System.out.println("Static Block Called");
	}

	public Test() {
		super();
		System.out.println("Inside Test Class Constructor");
	}
	
	
}
