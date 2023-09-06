package com.jio.ngo.beginnersbook.defaultstatic;

public class DefaultImpl implements DefaultInterface,StaticInterface{

	public static void main(String[] args) {
		DefaultImpl impl=new DefaultImpl();
		impl.defaultMethod();
		//impl.defaultM1();
		//StaticInterface.staticMethod();
	}

	@Override
	public void defaultM1() {
		System.out.println("Calling abstract Method");//NOSONAR
	}

	@Override
	public void defaultMethod() {
		StaticInterface.super.defaultMethod();
	}
}
