package com.jio.ngo.winterbe.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class WinterbeStream 
{
	
	public static void main(String[] args) 
	{
		//exampleOne();
		//exampleTwo();
		//exampleThree();
		//exampleFour();
		//exampleFive();
		//exampleSix();
		//exampleSeven();
		//exampleEight();
		//exampleNine();
		//exampleTen();
		//exampleEleven();
		//exampleTwelve();
		exampleThirteen();
	}
	
	/**
	 * Stream Supplier
	 * With get
	 */
	private static void exampleThirteen() 
	{
		Supplier<Stream<String>> streamSupplier=() ->Stream.of("a1","b2","c3","d4");
		//.filter(s->s.startsWith("b"));
		streamSupplier.get().filter(s-> {
			System.out.println("Filter " +s);
			return true;
		})
		.map(s -> {
			System.out.println("Map "+s);
			return s.toUpperCase();
		})
		.anyMatch(s-> {
			return s.startsWith("B");
		});
	}

	/**
	 * Stream Cannot Be Reused
	 */
	private static void exampleTwelve() 
	{
		Stream<String> stream=Stream.of("a1","b2","c3","d4")
		.filter(s->s.startsWith("a"));
		stream.anyMatch(s->true);
		stream.noneMatch(s->true);
	}

	/**
	 * Order With
	 * Match
	 */
	private static void exampleEleven() 
	{
		Stream.of("a1","b2","c3","d4")
		.map(s -> {
			System.out.println(s);
			return s.toUpperCase();
		})
		.anyMatch(s-> {
			System.out.println(s);
			return s.startsWith("B");
		});
	}
	/**
	 * Processing Order With
	 * Terminal Operation
	 */
	private static void exampleTen() 
	{
		Stream.of("a1","b2","c3","d4")
		.filter(s -> {
			System.out.println(s);
			return true;
		}).forEach(s -> System.out.println(s));
		
	}

	/**
	 * Processing Order
	 * Without Terminal 
	 * Operation
	 */
	private static void exampleNine() 
	{
		Stream.of("a1","a2","a3","a4")
		.filter(s -> {
			System.out.println(s);
			return true;
		});
		
	}

	private static void exampleEight() 
	{
		Stream.of(1.0,2.0,3.0,4.0)
		.mapToInt(Double::intValue)
		.mapToObj(value -> "A"+value)
		.forEach(System.out::println);
	}

	private static void exampleSeven() 
	{
		IntStream.range(1, 5)
		.mapToObj(value ->"a"+value)
		.forEach(System.out::println);
	}

	private static void exampleSix() 
	{
		Stream.of("a1","a2","a3")
		.map(value -> value.substring(1))
		.mapToInt(Integer::parseInt)
		.max()
		.ifPresent(System.out::println);
	}

	private static void exampleFive() 
	{
		Arrays.stream(new int[] {1,2,3})
		.map(n -> 2*n+1)
		.average()
		.ifPresent(System.out::println);
	}

	private static void exampleFour() 
	{
		IntStream.range(1, 4)
		.forEach(System.out::println);
	}

	/**
	 * Way of creating Stream
	 */
	private static void exampleThree() 
	{
		Stream.of("a1","a2","a3").findFirst().ifPresent(System.out::println);
		
	}

	/**
	 * Way of creating Stream
	 */
	private static void exampleTwo() 
	{
		Arrays.asList("a1","a2","a3")
		.stream().findFirst().ifPresent(System.out::println);
	}
	
	private static void exampleOne() 
	{
		 List<String> myList=Arrays.asList("a1", "a2", "b1", "c2", "c1");
		 myList.stream().filter(s -> s.startsWith("a"))
		 .map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
	}

}
