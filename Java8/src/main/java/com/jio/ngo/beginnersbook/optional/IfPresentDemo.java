package com.jio.ngo.beginnersbook.optional;

import java.util.Optional;

public class IfPresentDemo {

	public static void main(String[] args) {

		Optional<String> valueOne=Optional.ofNullable("This is Non Empty checked using IfPresent Method");
		Optional<String> valuetwo=Optional.empty();
		valueOne.ifPresent(System.out::println);
		valuetwo.ifPresent(System.out::println);
	}
}
