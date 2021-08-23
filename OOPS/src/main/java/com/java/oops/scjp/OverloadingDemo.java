package com.java.oops.scjp;

public class OverloadingDemo {

	public void m1()
	{
		System.out.println("No Argument COnstructor");
	}
	public void m1(int i)
	{
		System.out.println("Value of Integer Argument is "+i);
	}
	public void m1(double d)
	{
		System.out.println("Value of Double Argument is "+d);
	}
	public void m1(Object obj)
	{
		System.out.println("Object Argument");
	}
	public void m1(String string)
	{
		System.out.println("String Argument");
	}
	
	public void m1(StringBuffer stringBuffer)
	{
		System.out.println("StringBuffer Argument");
	}
	public void m1(int... i)
	{
		System.out.println("Vararg Method with Parameter "+i);
	}
	
	public static void main(String[] args) {
		OverloadingDemo demo=new OverloadingDemo();
		demo.m1();
		demo.m1(36);
		demo.m1('a');// Automatic promotion in Overloading
		demo.m1("Srinivas");
		//demo.m1(null);// Child class preference in case of overloading.
		//demo.m1(null);// CTE if both methods are at same level.
		demo.m1(35,24);
	}
}
