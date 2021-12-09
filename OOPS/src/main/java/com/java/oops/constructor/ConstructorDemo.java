package com.java.oops.constructor;

public class ConstructorDemo {

	static int count = 0;
	{
		count++;
	}

	ConstructorDemo() {
		System.out.println("Default Constructor");
	}

	ConstructorDemo(int i) {
		System.out.println("Integer Constructor");
	}

	public static void main(String[] args) {
		ConstructorDemo demo = new ConstructorDemo();
		ConstructorDemo demo1 = new ConstructorDemo(1);
		System.out.println(count);
	}
}
