package com.example.demo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringJoinerDemo {

	public static void main(String[] args) {
		int[] intArray = {234, 808, 342};
		
		/**
		 * Joining with Comma Separated Values
		 */
		String result = IntStream.of(intArray)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining("','","'","'"));
		System.out.println(result);
		
		String result1 = IntStream.of(intArray)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
		System.out.println(result1);
	}

}
