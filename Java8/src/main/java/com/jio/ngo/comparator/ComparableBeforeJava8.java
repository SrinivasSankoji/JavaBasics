package com.jio.ngo.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableBeforeJava8 {

	public static void main(String[] args) {
		
		//sorting Object array
		Employee[] empArr = new Employee[4];
		empArr[0] = new Employee(10, "Mikey", 25, 10000);
		empArr[1] = new Employee(20, "Arun", 29, 20000);
		empArr[2] = new Employee(5, "Lisa", 35, 5000);
		empArr[3] = new Employee(1, "Pankaj", 32, 50000);
		//Arrays.sort(empArr);
		Arrays.stream(empArr).sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);
	}

}
