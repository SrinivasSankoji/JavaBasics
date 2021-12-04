package com.jio.ngo.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAfterJava8 {
	static List<Employee> employeeList = Arrays.asList(new Employee(10, "Mikey", 25, 10000),
			new Employee(20, "Arun", 29, 20000), new Employee(5, "Lisa", 35, 5000),
			new Employee(1, "Pankaj", 32, 50000));

	public static void main(String[] args) {

		/**
		 * Comparator using Lambda Expression
		 */
		Comparator<Employee> nameComparator = (employee1, employee2) -> employee1.getName().compareTo(employee2.getName());

		/**
		 * Comparator using Method Reference
		 */
		//Collections.sort(employeeList, Comparator.comparing(Employee::getName));
		Collections.sort(employeeList,Comparator.comparing(Employee::getName).reversed()); // Reverse Order
		//Collections.sort(employeeList, Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
		employeeList.stream().forEach(System.out::println);

	}
}
