package com.jio.ngo.winterbe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class WinterbeStream {

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
		exampleNine();
	}

	private static void exampleNine() 
	{
		
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

	private static void exampleThree() 
	{
		Stream.of("a1","a2","a3").findFirst().ifPresent(System.out::println);
		
	}

	private static void exampleTwo() 
	{
		Arrays.asList("a1","a2","a3")
		.stream().findFirst().ifPresent(System.out::println);
	}
	
	private static void exampleOne() 
	{
		 List<String> myList=Arrays.asList("a1", "a2", "b1", "c2", "c1");
		 myList.stream().filter(s -> s.startsWith("a"))
		.sorted()
		.forEach(System.out::println);
	}

}
