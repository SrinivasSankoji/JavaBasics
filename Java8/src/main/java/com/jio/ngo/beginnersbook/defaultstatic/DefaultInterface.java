package com.jio.ngo.beginnersbook.defaultstatic;

public interface DefaultInterface {

	//default Method
	default void defaultMethod()
	{
		System.out.println("Overriding default Method in the DefaultInterface");
	}
	
	//static Method
	static void staticMethod()
	{
		System.out.println("Overriding static Method in the DefaultInterface");
	}
	//abstract method
	public void defaultM1();	
}
