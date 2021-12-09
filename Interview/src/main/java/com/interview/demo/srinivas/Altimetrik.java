package com.interview.demo.srinivas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Altimetrik {

	public static <E> void main(String[] args) {
		// Array of (12 ,13 -2876 , 52 , -111 )
		// Java program to list highest valued first 2 numbers.
		int[] intArray = { 12, 13, -2876, 52, -111 };
		Arrays.sort(intArray);
		// System.out.println(Arrays.toString(intArray));

		List<Integer> result = Arrays.stream(intArray).boxed().sorted(Comparator.reverseOrder()).limit(2)
				.collect(Collectors.toList());
		result.forEach(System.out::println);

		// Write a logic to get the 4th element from last in a linked list.
		LinkedList<String> link = new LinkedList<String>();
		link.add("ABC");
		link.add("DEF");
		link.add("GHI");
		link.add("IJK");
		link.add("LMN");

		// Code to iterate HashMap
		// using While and advance for loop.
		HashMap<String, Object> map = new HashMap<>();
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("C", "Cat");
		map.put("D", "Dog");
		map.put("E", "Elephant");

		/**
		 * Using Advanced For Loop
		 */
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}

		// Using While Loop
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			System.out.println(entry.getKey() + " -- " + entry.getValue());
		}

		// Program to remove all white spaces from a string without using replace().
		String removeSpace = "Srinivas is inter  vier ing to day";
		String[] resArray = removeSpace.split("\\s");
		StringBuilder builder = new StringBuilder();
		Arrays.asList(resArray).forEach(builder::append);// To convert List to String using Java 8
		// System.out.println(builder);

		/**
		 * Convert List to String using reduce
		 */
		String listToString = Arrays.asList(resArray).stream().reduce("", String::concat);
		System.out.println(listToString);

		/**
		 * Convert List to String using collect
		 */
		String listToStr = Arrays.asList(resArray).stream().collect(Collectors.joining(""));
		// System.out.println(listToStr);
	}

}
