package com.java.oops.scjp;

public class MethodSignatureDemo {

	public void m1(int i)
	{
		System.out.println("Integer Value is "+i);
	}
	
	public void m1(double d,int i)
	{
		System.out.println("Integer Value is "+i + "and Double Value is "+d );
	}
	public static void main(String[] args) {
		MethodSignatureDemo demo =new MethodSignatureDemo();
		demo.m1(5);
		demo.m1(36.0,5);
		
	}
}
