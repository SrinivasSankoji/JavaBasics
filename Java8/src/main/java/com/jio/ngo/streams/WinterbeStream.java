package com.jio.ngo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WinterbeStream {

	public static void main(String[] args) {
		exampleOne();
		exampleTwo();
		exampleThree();
		exampleFour();
		exampleFive();
		exampleSix();
		exampleSeven();
		exampleEight();
		exampleNine();
		exampleTen();
		exampleEleven();
		exampleTwelve();
		exampleThirteen();
		exampleFourteen();
		exampleFifteen();
		findEvenNumbers();
	}

	/**
	 * Way of creating Stream using stream()
	 */
	private static void exampleOne() {
		System.out.println("Example One --> Way of creating Stream using stream() --> Start ");
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
		System.out.println("Example One --> Way of creating Stream using stream() --> End ");
	}

	/**
	 * Way of creating Stream using stream()
	 */
	private static void exampleTwo() {
		System.out.println("Example Two --> Way of creating Stream using stream() --> Start ");
		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
		System.out.println("Example Two --> Way of creating Stream using stream() --> End ");
	}

	/**
	 * Way of creating Stream using Stream.of
	 */
	private static void exampleThree() {
		System.out.println("Example Three --> Way of creating Stream using Stream.of() --> Start ");
		Stream.of("a1", "a2", "a3").findFirst().ifPresent(System.out::println);
		System.out.println("Example Three --> Way of creating Stream using Stream.of() --> End ");
	}

	/**
	 * Way of creating IntStream
	 */
	private static void exampleFour() {
		System.out.println("Example Four --> Way of creating IntStream --> Start ");
		IntStream.range(1, 4).forEach(System.out::println);
		System.out.println("Example Four --> Way of creating IntStream --> End ");
	}

	/**
	 * Way of creating Stream using Arrays.stream and Average of the Integer
	 */
	private static void exampleFive() {
		System.out.println("Example Five --> Way of creating using Arrays.stream --> Start ");
		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
		System.out.println("Example Five --> Way of creating using Arrays.stream --> End ");
	}
	
	private static void findEvenNumbers() {
		System.out.println("Example Five --> Way of creating using Arrays.stream --> Start ");
		Arrays.stream(new int[] { 1, 2, 3 }).filter(n -> n%2==0).forEach(System.out::println);
	}

	/**
	 * Way of creating Stream using Stream.of
	 */
	private static void exampleSix() {
		System.out.println("Example Six --> Way of creating using Stream.of --> Start ");
		Stream.of("a1", "a2", "a3").map(value -> value.substring(1)).mapToInt(Integer::parseInt).max()
				.ifPresent(System.out::println);
		System.out.println("Example Six --> Way of creating using Stream.of --> End ");
	}

	/**
	 * Way of creating Stream using IntStream and Converting into Object
	 */
	private static void exampleSeven() {
		System.out.println("Example Seven --> Way of creating using IntStream and Converting into Object --> Start ");
		IntStream.range(1, 5).mapToObj(value -> "a" + value).forEach(System.out::println);
		System.out.println("Example Seven --> Way of creating using IntStream and Converting into Object --> End ");
	}

	/**
	 * Way of creating Stream using Stream.of and Converting into Object
	 */
	private static void exampleEight() {
		System.out.println("Example Eight --> Way of creating using Stream.of and Converting into Object --> Start ");
		Stream.of(1.0, 2.0, 3.0, 4.0).mapToInt(Double::intValue).mapToObj(value -> "A" + value)
				.forEach(System.out::println);
		System.out.println("Example Eight --> Way of creating using Stream.of and Converting into Object --> End ");
	}

	/**
	 * Processing Order without Terminal Operation
	 */
	private static void exampleNine() {
		System.out.println("Example Nine --> Processing Order without Terminal Operation --> Start ");
		Stream.of("a1", "a2", "a3", "a4").filter(s -> {
			System.out.println(s);
			return true;
		});
		System.out.println("Example Nine --> Processing Order without Terminal Operation --> End ");
	}

	/**
	 * Processing Order with Terminal Operation
	 */
	private static void exampleTen() {
		System.out.println("Example Ten --> Processing Order with Terminal Operation --> Start ");
		Stream.of("a1", "b2", "c3", "d4").filter(s -> {
			System.out.println(s);
			return true;
		}).forEach(s -> System.out.println(s));
		System.out.println("Example Ten --> Processing Order with Terminal Operation --> End ");
	}

	/**
	 * Order With AnyMatch
	 */
	private static void exampleEleven() {
		System.out.println("Example Eleven --> Order With Match --> Start ");
		Stream.of("a1", "b2", "c3", "d4").peek(System.out::println).map(String::toUpperCase).anyMatch(s -> s.startsWith("B"));
		System.out.println("Example Eleven --> Order With Match --> End ");
	}

	/**
	 * Stream Cannot Be Reused
	 */
	private static void exampleTwelve() {
		System.out.println("Example Twelve --> Stream Cannot Be Reused --> Start ");
		Stream<String> stream = Stream.of("a1", "b2", "c3", "d4").filter(s -> s.startsWith("a"));
		stream.anyMatch(s -> true);
		//stream.noneMatch(s -> true);//Streams cannot be reused and throws IllegalStateException stream has already been operated upon or closed
		System.out.println("Example Twelve --> Stream Cannot Be Reused--> End ");
	}

	/**
	 * Stream Supplier with get
	 */
	private static void exampleThirteen() {
		System.out.println("Example Thirteen --> Stream Supplier With get --> Start ");
		Supplier<Stream<String>> streamSupplier = () -> Stream.of("a1", "b2", "c3", "d4");
		// .filter(s->s.startsWith("b"));
		streamSupplier.get().filter(s -> {
			System.out.println("Filter " + s);
			return true;
		}).map(s -> {
			System.out.println("Map " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			return s.startsWith("B");
		});
		streamSupplier.get().anyMatch(s -> {
			System.out.println("AnyMatch " + s);
			return s.startsWith("a1");
		});
		System.out.println("Example Thirteen --> Stream Supplier With get --> End ");
	}
	
	/**
	 * Creating Stream using generate() to generate the Random Numbers
	 * generate() generates the Infinite Streams
	 */
	private static void exampleFourteen() {
		Stream<Double> generate=Stream.generate(Math::random).limit(10);
		Double[] strArray=generate.toArray(Double[]::new);
		System.out.println(Arrays.toString(strArray));
	}
	
	/**
	 * Creating Streams using iterate().
	 * iterate() can be used to create the Infinite Streams
	 */
	private static void exampleFifteen() {
		Stream<Integer> intStream=Stream.iterate(0, n -> n+1).limit(10);
		Integer[] intArray=intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));
	}
}
