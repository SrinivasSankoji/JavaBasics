package com.javainterview.modifiers;

public class FinalDemo {
	/**
	 * final instance variables
	 */
	final int x=10;
	final int y;
	{
		y=10;
	};
	final int z;
	FinalDemo()
	{
		z=10;
	};
	
	/**
	 * final static variables
	 */
	static final  int i=36;
	static final int j=29;
	
	public static void m1(int x,int y)
	{
		x=36;
		y=25;
	}
	public static void main(String[] args) {
		m1(25,22);
	}
}
