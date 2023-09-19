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
		countOccurrenceOfTheElements();
		countNumberOfWords();
	}


	 /* Count the length of each element in the String */
	private static void collectStreamResultsToArray(List<String> list) {
		Stream<String> stream = list.stream();
		Stream<Integer> intStream = stream.map(s -> s.length());
		Integer[] intArray = intStream.toArray(Integer[]::new);
		// System.out.println(Arrays.toString(intArray)); // [4, 3, 6]
		Map<String, Integer> listCount = list.stream()
				.collect(Collectors.toMap(Function.identity(), w -> w.length(), Integer::sum));
		System.out.println("Collect Stream Results To Array " + listCount);// {python=6, java=4, php=3}
	}

	/* Word Length in the List */
	private static void collectStreamResultsToMap(List<String> list) {
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), s -> s.length()));
		System.out.println("Collect Stream Results To Map " +map);// {python=6, java=4, php=3}
	}

	/* Occurrence of Numbers */
	private static void countOccurrenceOfTheElements() {
		ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
		Map<Integer, Long> occurences = numbersList.stream()
				.collect(Collectors.toMap(Function.identity(), s -> 1L, Long::sum));
		System.out.println("Occurrence of Numbers " +occurences);// {1=2, 2=1, 3=3, 4=1, 5=1, 6=3, 7=1, 8=1}
	}

	/* Occurrence of each word in the String using Java 8 */
	private static void countNumberOfWords() {
		String str = "This this is is done by Saket Saket";
		List<String> temp = Stream.of(str.split("\\s")).collect(Collectors.toList());
		Map<String, Integer> wordCounter = temp.stream()
				.collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum));
		System.out.println("Collect Stream Results To Word Count "+wordCounter);// {Saket=2, by=1, this=1, This=1, is=2, done=1}
	}
}
