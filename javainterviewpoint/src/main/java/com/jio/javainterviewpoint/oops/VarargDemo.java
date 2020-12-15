package com.jio.javainterviewpoint.oops;

public class VarargDemo {

	public static void m1(int... x)
	{
		System.out.println("Vararg Method");
	}
	
	public static void m2(int... x)
	{
		int total=0;
		for(int y:x)
		{
			total=total+y;
		}
		System.out.println("Vararg Method Total is :"+total);
	}
	public static void main(String[] args) {
		m2(1);
		m2(1,2);
		m2(1,2,3);
	}

}
