package com.jio.ngo.streams;

import java.util.Arrays;

public class ConcretePageReduce {

	public static void main(String[] args) {
		reduceWithBinaryOperator();
		reduceWithIdentityBinaryOperator();
	}

	private static void reduceWithBinaryOperator() {
		int[] intArray= {23,43,56,97,32};
		Arrays.stream(intArray).reduce((x,y) -> x+y).ifPresent(System.out::println);
		Arrays.stream(intArray).reduce(Integer::sum).ifPresent(System.out::println);
	}
	
	private static void reduceWithIdentityBinaryOperator() {
		int sum=0;
		int[] intArray= {23,43,56,97,32};
		sum=Arrays.stream(intArray).reduce(100,Integer::sum);
		System.out.println(sum);
	}

}
