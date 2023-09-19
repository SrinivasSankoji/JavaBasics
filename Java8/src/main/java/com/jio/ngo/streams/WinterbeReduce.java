package com.jio.ngo.streams;

import java.util.Arrays;
import java.util.List;

import com.jio.ngo.winterbe.model.Person;

public class WinterbeReduce {

	public static void main(String[] args) {
		reduceOne();
		reduceTwo();
		reduceThree();
		concatNames();
	}

	/* reduce() to get the Person with the highest age */
	private static void reduceOne() {
		List<Person> persons = Arrays.asList(new Person("Max", null, 18), new Person("Peter", null, 23),
				new Person("Pamela", null, 23), new Person("David", null, 12));
		persons.stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2).ifPresent(System.out::println);
	}

	private static void reduceTwo() {
		List<Person> persons = Arrays.asList(new Person("Max", null, 18), new Person("Peter", null, 23),
				new Person("Pamela", null, 23), new Person("David", null, 12));
		Person result = persons.stream().reduce(new Person("", null, 0), (p1, p2) -> {
			p1.age += p2.age;
			p1.firstName += p2.lastName;
			return p1;
		});
		System.out.println(result.getFirstName() + "   " + result.getAge());
	}

	private static void reduceThree() {
		List<Person> persons = Arrays.asList(new Person("Max", null, 18), new Person("Peter", null, 23),
				new Person("Pamela", null, 23), new Person("David", null, 12));
		Integer ageSum = persons.stream().reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
		System.out.println(ageSum);
	}

	/* reduce() to concat the String */
	private static void concatNames() {
		List<String> names = Arrays.asList("Srinivas", "Sankoji");
		names.stream().reduce((fName, lName) -> fName + " " + lName).ifPresent(System.out::println);
	}

}
