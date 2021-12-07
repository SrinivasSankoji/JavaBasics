package com.java.string.scjp;

import java.util.Arrays;
import java.util.Comparator;

public class StringReverse {

	public static void main(String[] args) {
		
		/**
		 * Reverse the String
		 */
		String str="Automation";
		Arrays.stream(str.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
		
		
	}

}
