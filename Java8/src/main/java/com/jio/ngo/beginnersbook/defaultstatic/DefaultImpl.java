package com.jio.ngo.beginnersbook.defaultstatic;

public class DefaultImpl implements DefaultInterface,StaticInterface{

	public static void main(String[] args) {
		DefaultImpl defaultImpl=new DefaultImpl();
		defaultImpl.defaultMethod();
		defaultImpl.defaultM1();
		StaticInterface.staticMethod();
	}

	/* First approach - provide own implementation */
	@Override
	public void defaultM1() {
		System.out.println("Calling own implementation");
	}

	/* Second approach - Explicitly specify which default method to use */
	@Override
	public void defaultMethod() {
		DefaultInterface.super.defaultMethod();
	}
}
