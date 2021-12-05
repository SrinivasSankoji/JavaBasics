package com.jio.ngo.boraji.function;

public class FunctionInterfaceDemo {

	public static void main(String[] args) {
		AddFunctionalInterface addFunctionalInterface=(a,b) -> a+b;
		System.out.println(addFunctionalInterface.add(23,15));
		
		StringFunctionInterface stringFunctionInterface=(message) -> System.out.println(message);
		stringFunctionInterface.displayMessage("Hello World");
	}
}
