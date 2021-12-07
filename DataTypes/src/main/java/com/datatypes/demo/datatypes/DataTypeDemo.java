package com.datatypes.demo.datatypes;

public class DataTypeDemo {

	public static void main(String[] args) {
		System.out.println(1.0/0); // Infinity
		
		//Swap of Two Numbers without using third variable
		int x=10;
		int y=0;
		x=x+y; //x=10
		y=x-y; //y=10
		x=x-y; //0
		System.out.println("X is "+x + " Y is " +y);
	}

}
