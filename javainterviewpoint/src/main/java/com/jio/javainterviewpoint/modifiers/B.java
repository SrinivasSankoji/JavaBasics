package com.jio.javainterviewpoint.modifiers;
import com.jio.javainterviewpoint.classloading.A;
public class B extends A{
	protected void m3() {
		System.out.println("Inside modifiers Child Package");
	}
	public static void main(String[] args) {
		B b=new B();
		b.m2();
		
		A a=new A();
		//a.m2();
		
		A a1=new B();
		//a1.m2();
	}
}
