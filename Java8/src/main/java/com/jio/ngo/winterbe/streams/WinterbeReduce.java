package com.jio.ngo.winterbe.streams;

import java.util.Arrays;
import java.util.List;

import com.jio.ngo.winterbe.model.Person;

public class WinterbeReduce {

	public static void main(String[] args) 
	{
		//reduceOne();
		//reduceTwo();
		//reduceThree();
		concatNames();
	}

	private static void reduceThree() 
	{
		List<Person> persons = 
		Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
		new Person("David", 12));
		Integer ageSum=persons.stream()
		.reduce(0, (sum,p)->sum+=p.age, (sum1,sum2)->sum1+sum2);
		System.out.println(ageSum);
	}

	@SuppressWarnings("unused")
	private static void reduceTwo() 
	{
		List<Person> persons = 
		Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
		new Person("David", 12));
		Person result=persons.stream().reduce(new Person("",0), (p1,p2) ->
		{
			p1.age+=p2.age;
			p1.name+=p2.name;
			return p1;
		});
		System.out.println(result.getName()+ "   " +result.getAge());
	}

	@SuppressWarnings("unused")
	private static void reduceOne() 
	{
		List<Person> persons = 
		Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
		new Person("David", 12));
		persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);
	}
	
	private static void concatNames() {
		List<String> names = Arrays.asList("Srinivas", "Sankoji");
		names.stream().reduce((fName, lName) -> fName + " " + lName).ifPresent(System.out::println);
	}

}
