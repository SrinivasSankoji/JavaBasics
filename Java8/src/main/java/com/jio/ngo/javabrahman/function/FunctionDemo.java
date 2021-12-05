package com.jio.ngo.javabrahman.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));

		/**
		 * Functional Interface Accepts Employee and Returns String
		 */
		Function<Employee, String> functionString = (e) -> {
			return e.getName();
		};

		/**
		 * Functional Interface Accepts String and Returns String
		 */
		Function<String, String> initialFunction = (s) -> s.substring(0, 1);

		/**
		 * Functional Interface Accepts Employee and Returns Employee
		 */
		Function<Employee, Employee> employeeFunction = (e) -> {
			int index = e.getName().indexOf(" ");
			String firstName = e.getName().substring(0, index);
			e.setName(firstName);
			return e;
		};

		/**
		 * Convert Employee Names into List of String
		 */

		List<String> names1 = convertNamesToString(employeeList, functionString);
		List<String> names2 = convertNamesToString(employeeList, functionString.andThen(initialFunction));
		List<String> names3 = convertNamesToString(employeeList, functionString.compose(employeeFunction));
		List<Employee> names4 = convertIdentity(employeeList, Function.identity());
		names4.forEach(System.out::println);

	}

	private static List<Employee> convertIdentity(List<Employee> employeeList,
			Function<Employee, Employee> functionString) {
		List<Employee> names = new ArrayList<>();
		for (Employee employee : employeeList) {
			names.add(functionString.apply(employee));
		}
		return employeeList;
	}

	private static List<String> convertNamesToString(List<Employee> employeeList,
			Function<Employee, String> functionString) {
		List<String> names = new ArrayList<>();
		for (Employee employee : employeeList) {
			names.add(functionString.apply(employee));
		}
		return names;

	}
}
