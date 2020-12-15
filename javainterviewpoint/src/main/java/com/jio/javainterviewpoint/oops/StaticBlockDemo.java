package com.jio.javainterviewpoint.oops;

public class StaticBlockDemo {
	
	String name;
	int[] i;
	static {
		System.out.println("Without executing Main Method");
	}
	{
		name="Bhaumik Sankoji";
	}
	public static void main(String[] args) {
		StaticBlockDemo  staticBlockDemo=new StaticBlockDemo();
		System.out.println(staticBlockDemo.i);
		System.out.println(staticBlockDemo.name);
	}
}
