package com.interview.demo.srinivas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IvyComptech {

	public static void main(String[] args) {

		/**
		 * Starts with "A"
		 */
		String[] strArray= {"Apple","Ant","Ball"};
		List<String> result=Arrays.stream(strArray).filter(s -> s.startsWith("A")).collect(Collectors.toList());
		result.forEach(System.out::println);
	}

}
