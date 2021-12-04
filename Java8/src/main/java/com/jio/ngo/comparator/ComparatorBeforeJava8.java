package com.jio.ngo.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBeforeJava8 {
	static List<Employee> employeeList = Arrays.asList(new Employee(10, "Mikey", 25, 10000),
			new Employee(20, "Arun", 29, 20000), new Employee(5, "Lisa", 35, 5000),
			new Employee(1, "Pankaj", 32, 50000));
	
	/**
	 * Comparator Before Java 8
	 */
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};

	public static void main(String[] args) {
		/**
		 * Using List Interface sort()
		 */
		//employeeList.sort(new NameComparator());
		/**
		 * Using Collections Class sort()
		 */
		Collections.sort(employeeList,nameComparator);
		employeeList.forEach(System.out::println);
	}
}

