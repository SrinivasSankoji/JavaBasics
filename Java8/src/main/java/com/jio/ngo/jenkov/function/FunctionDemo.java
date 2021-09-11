package com.jio.ngo.jenkov.function;

import java.util.function.Function;

public class FunctionDemo {
	Function<Integer, Integer> sum= (value -> value+value);
	public static void main(String[] args) {
		FunctionDemo demo=new FunctionDemo();
		Integer addNumbers=demo.sum.apply(5);
		System.out.println(addNumbers);
	}
}
