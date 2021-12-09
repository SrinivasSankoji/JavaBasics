package com.interview.demo.srinivas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AltemetrikInterview {

	public static void main(String[] args) {
		String result = "Orange2Apple5Banana69";
		String[] text = result.split("\\D");
		System.out.println(Arrays.toString(text));
		// Arrays.stream(text).collect(Collectors.toMap(Function.identity(), s
		// ->s.length()));

		List<Character> characterStream = result.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
		for (Character ch : characterStream) {
			if (ch instanceof Character) {

			}

		}

		System.out.println("\n*******************************");

		/**
		 * Missing Number
		 */
		int[] numbers = { 5, 4, 8, 6, 10 };
		Arrays.sort(numbers);
		List<Integer> serachSeries = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		List<Integer> totalSeries = IntStream.range(numbers[0], numbers[numbers.length - 1]).boxed()
				.collect(Collectors.toList());
		totalSeries.removeAll(serachSeries);
		totalSeries.stream().forEach(System.out::println);

		System.out.println("\n*******************************");
		/**
		 * Post Increment
		 */
		byte firstValue = 10;
		firstValue++;
		System.out.println(firstValue);
		byte secondValue = 10;
		secondValue = (byte) (secondValue + 1);
		System.out.println(secondValue);

	}

}
