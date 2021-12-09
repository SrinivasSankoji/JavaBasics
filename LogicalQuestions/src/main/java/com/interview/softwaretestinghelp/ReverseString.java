package com.interview.softwaretestinghelp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {
		String string = "Automation";

		/**
		 * Using char Array
		 */
		char[] charArray = string.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			char c = charArray[i];
			// System.out.println(c);
		}

		/**
		 * Using Java 8 Streams
		 */
		List<Character> charList = string.chars().mapToObj(element -> (char) element).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		String reversed = charList.stream().map(String::valueOf).collect(Collectors.joining());
		// System.out.println(reversed);

	}

}
