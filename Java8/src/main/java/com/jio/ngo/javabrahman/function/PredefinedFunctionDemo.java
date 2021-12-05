package com.jio.ngo.javabrahman.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunctionDemo {
	Function<Integer, Integer> sum = (value -> value + value);
	Predicate<String> nullCheck = (value -> value != null && value != "");
	Consumer<String> display = (value -> System.out.println(value));
	Supplier<String> fetch = () -> "Get the Value from Supplier";

	public static void main(String[] args) {
		PredefinedFunctionDemo demo = new PredefinedFunctionDemo();

		// Calling Function Interface
		System.out.println(demo.sum.apply(23));

		// Calling Predicate Interface
		System.out.println(demo.nullCheck.test(""));

		// Calling Consumer Interface
		demo.display.accept("Srinivas Sankoji");

		// Calling Supplier Interface
		System.out.println(demo.fetch.get());
	}
}
