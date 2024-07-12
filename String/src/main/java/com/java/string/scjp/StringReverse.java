package com.java.string.scjp;

import java.util.Arrays;
import java.util.Comparator;

public class StringReverse {

	public static void main(String[] args) {

		/* Reverse the String */
		String str="Automation";
		//Arrays.stream(str.split("")).sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.println(reverseWithoutSpecialChars("a$bc%de"));

	}

	public static String reverseWithoutSpecialChars(String input) {
		// Extract alphabetic characters
		StringBuilder letters = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				letters.append(c);
			}
		}
		return letters.reverse().toString();
	}

}
