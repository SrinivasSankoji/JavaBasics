package com.jio.ngo.beginnersbook.methodreference;

public class Example {

	public void myMethod(){  
		System.out.println("Instance Method");  
	}
	public static void main(String[] args) {
		Example example=new Example();
		
		
		
		MyInterface reference = () -> example.myMethod();
		// If the Lambda Expression does not accept any argument and executing a Method
		// then use the Method Reference.
		MyInterface reference1 = example::myMethod;
		
		reference.disply();
		reference1.disply();
	}
}

interface MyInterface{
	 void disply();
}
