package com.java.arraylist.javabrahman;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorOldWay {
	
	static List<Employee> employeeList = 
		      Arrays.asList(new Employee("Tom Jones", 45), 
		        new Employee("Harry Major", 35),
		        new Employee("Harry Major", 25), 
		        new Employee("Ethan Hardy", 65), 
		        new Employee("Nancy Smith", 15),
		        new Employee("Deborah Sprightly", 29));
	
	public static void main(String[] args) {
		/**
		 * Comparator using Lambda Expression
		 */
		Comparator<Employee> nameComparator = (Employee e1, Employee e2) -> {
			return e1.getName().compareTo(e2.getName());
		};
		
		/**
		 * Comparator using comparing
		 */
		Comparator<Employee> nameComparing=Comparator.comparing(Employee::getName);
		
		/**
		 * Comparator using then Comparing
		 */
		Comparator<Employee> nameAgeComparing=Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);
		Collections.sort(employeeList,nameAgeComparing);
		System.out.println(employeeList);
		
		List<String> empList=employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		empList.sort(Comparator.reverseOrder());
		System.out.println(empList);
	}
}
/**
 * Old Way of Comparator
 */
class NameComparator implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}
