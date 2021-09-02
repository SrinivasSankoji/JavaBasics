package com.jio.ngo.beginnersbook.defaultstatic;

public interface StaticInterface {

	//default Method
	default void defaultMethod()
	{
		System.out.println("Overriding default Method in the StaticInterface");
	}
		
	//static Method
	static void staticMethod()
	{
		System.out.println("Overriding static Method in the StaticInterface");
	}
}
