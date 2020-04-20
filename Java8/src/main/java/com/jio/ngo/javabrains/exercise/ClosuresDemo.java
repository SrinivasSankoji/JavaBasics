package com.jio.ngo.javabrains.exercise;

import java.util.function.IntConsumer;

public class ClosuresDemo {

	public static void main(String[] args) 
	{
		int a=10;
		int b=20;
		doProcess(a,i-> System.out.println(i+b));
	}
	
	private static void doProcess(int i,IntConsumer consumer) 
	{
		consumer.accept(i);
	}
}
