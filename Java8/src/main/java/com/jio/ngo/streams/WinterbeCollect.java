package com.jio.ngo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jio.ngo.winterbe.model.Person;
import com.jio.ngo.winterbe.model.Student;

public class WinterbeCollect {
	public static void main(String[] args) {
		basicCollect();
		summarizingInt();
		joining();
		averagingInt();
		collectorMap();
		groupingBy();
	}

	/**
	 * Basic collect using Map
	 */
	private static void basicCollect() {
		System.out.println("basicCollect --> Start ");
		List<Person> persons = Arrays.asList(new Person("Max", null, 18), new Person("Peter", null, 23),
				new Person("Pamela", null, 23), new Person("David", null, 12));
		List<Integer> result = persons.stream().map(Person::getAge).collect(Collectors.toList());
		result.forEach(number -> System.out.println(number));
		System.out.println("basicCollect --> End ");
	}

	/**
	 * collect to get the Summary Statistics
	 */
	private static void summarizingInt() {
		System.out.println("summarizingInt --> Start ");
		List<Integer> integerArray = Arrays.asList(25, 36, 81);
		IntSummaryStatistics statistics = integerArray.stream()
				.collect(Collectors.summarizingInt(number -> number + number));
		System.out.println(statistics.getSum());
		System.out.println("summarizingInt --> End ");

	}

	/**
	 * collect to perform the joining the stream
	 */
	private static void joining() {
		System.out.println("joining --> Start ");
		List<String> names = Arrays.asList("Ram", "Shyam", "Shiv", "Mahesh");
		String result = names.stream().collect(Collectors.joining("','", "['", "']"));
		System.out.println(result);
		System.out.println("joining --> End ");
	}

	/**
	 * collect to perform Aggregation
	 */
	private static void averagingInt() {
		System.out.println("averagingInt --> Start ");
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Double average = list.stream().collect(Collectors.averagingInt(number -> number * 2));
		System.out.println("Average is "+average);
		System.out.println("averagingInt --> End ");
	}

	/**
	 * collect to transform the result into Map
	 */
	private static void collectorMap() {
		System.out.println("collectorMap --> Start ");
		List<Person> list = new ArrayList<>();
		list.add(new Person("Srinivas", "Sankoji", 100));
		list.add(new Person("Nandini", "Sankoji", 200));
		list.add(new Person("Bhaumik", "Sankoji", 200));
		list.add(new Person("Aadvik", "Sankoji", 300));
		Map<String, String> result = list.stream().collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
		result.forEach((x, y) -> System.out.println(x + " " + y));
		System.out.println("collectorMap --> End ");
	}

	/**
	 * collect to perform Grouping
	 */
	private static void groupingBy() {
		System.out.println("groupingBy --> Start ");
		Student s1 = new Student("Ram", 20, "A");
		Student s2 = new Student("Shyam", 22, "B");
		Student s3 = new Student("Mohan", 22, "A");
		Student s4 = new Student("Mahesh", 20, "C");
		Student s5 = new Student("Krishna", 21, "B");
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5);
		Map<String, List<Student>> result = list.stream().collect(Collectors.groupingBy(Student::getClassName));
		List<Student> results = result.entrySet().stream().map(Map.Entry::getValue).flatMap(List::stream)
				.collect(Collectors.toList());
		results.forEach(s -> System.out.println(s));
		System.out.println("groupingBy --> End ");
	}

}
