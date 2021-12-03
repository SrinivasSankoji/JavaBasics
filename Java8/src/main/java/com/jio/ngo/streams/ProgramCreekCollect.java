package com.jio.ngo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgramCreekCollect {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");

		collectStreamResultsToArray(list);
		collectStreamResultsToMap(list);
		countOccurenceOfTheElements();
	}

	/**
	 * Collect Stream Results To Array ie Count the length of each element in the String
	 */
	private static void collectStreamResultsToArray(List<String> list) {
		Stream<String> stream = list.stream();
		Stream<Integer> intStream = stream.map(s -> s.length());
		Integer[] intArray = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); // [4, 3, 6]
	}
	
	/**
	 * Collect Stream Results to Map ie Word Length in the List
	 */
	private static void collectStreamResultsToMap(List<String> list) {
		Map<String, Integer> map=list.stream().collect(Collectors.toMap(Function.identity(), s->s.length()));
		System.out.println(map);// {python=6, java=4, php=3}
	}
	
	/**
	 * Collectors.toMap() to count Occurrence
	 */
	private static void countOccurenceOfTheElements() {
		ArrayList<Integer> numbersList 
	    = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		Map<Integer, Long> occurences=numbersList.stream().collect(Collectors.toMap(Function.identity(), s ->1L,Long::sum));
		System.out.println(occurences);
	}
}
