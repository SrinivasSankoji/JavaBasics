package com.jio.ngo.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorNullsFirst {

	public static void main(String[] args) {

		String[] strArray = { "aman", "suvam", null, "sahil", null };
		/**
		 * nullsFirst for primitive Types
		 */
		Arrays.sort(strArray, Comparator.nullsFirst(Comparator.naturalOrder()));
		Arrays.stream(strArray).forEach(System.out::println);

		/**
		 * nullsFirst for Custom Object
		 */
		User u1 = new User("Aaman", 25);
		User u2 = new User("Joyita", 22);
		User u3 = new User("Suvam", 28);
		User u4 = new User("mahafuj", 25);

		System.out.println("******************");
		List<User> list = Arrays.asList(u1, u2, u3, null, u4);
		
		list.sort(Comparator.nullsFirst(Comparator.comparing(User::getName)));
		list.stream().forEach(System.out::println);
		System.out.println("******************");
		Collections.sort(list,Comparator.nullsLast(Comparator.comparing(User::getAge)));
		list.stream().forEach(System.out::println);
		
		list.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getName));

	}
}
