package com.jio.ngo.winterbe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinterbeCollect 
{
	public static void main(String[] args) 
	{
		//basicCollect();
		//summarizingInt();
		//joining();
		//averagingInt();
		//collectorMap();
		groupingBy();
	}

	private static void groupingBy() 
	{
		Student s1 = new Student("Ram", 20, "A");
		Student s2 = new Student("Shyam", 22, "B");
		Student s3 = new Student("Mohan", 22, "A");
		Student s4 = new Student("Mahesh", 20, "C");
		Student s5 = new Student("Krishna", 21, "B");
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
		Map<String, List<Student>> result = list.stream().collect(Collectors.groupingBy(Student::getClassName));
		Optional<List<Student>> results = result.entrySet().stream().map(Map.Entry::getValue).findAny();
		results.get().forEach(s -> System.out.println(s));

	}

	@SuppressWarnings("unused")
	private static void collectorMap() 
	{
		List<Person> list = new ArrayList<>();
		list.add(new Person("Mohan", 100));
		list.add(new Person("Sohan", 200));
		list.add(new Person("Mahesh", 300));
		Map<Integer, String> result=list.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
		result.forEach((x,y)-> System.out.println(x +" " + y));
	}

	@SuppressWarnings("unused")
	private static void averagingInt() 
	{
		List<Integer> list = Arrays.asList(1,2,3,4);
		Double average=list.stream().collect(Collectors.averagingInt(number->number*2));
		System.out.println(average);
	}

	@SuppressWarnings("unused")
	private static void joining() 
	{
		List<String> names=Arrays.asList("Ram","Shyam","Shiv","Mahesh");
		String result=names.stream().collect(Collectors.joining("','", "'", "'"));
		System.out.println(result);
	}

	@SuppressWarnings("unused")
	private static void summarizingInt() 
	{
		List<Integer> integerArray=Arrays.asList(25,36,81);
		IntSummaryStatistics statistics=integerArray.stream().collect(Collectors.summarizingInt(number->number+number));
		System.out.println(statistics.getSum());
		
	}

	@SuppressWarnings("unused")
	private static void basicCollect() 
	{
		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Pamela", 23),
				new Person("David", 12));
		List<Integer> result = persons.stream().map(Person::getAge).collect(Collectors.toList());
		result.forEach(number -> System.out.println(number));
	}

}
