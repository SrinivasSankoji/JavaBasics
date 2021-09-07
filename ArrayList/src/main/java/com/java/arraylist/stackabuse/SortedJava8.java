package com.java.arraylist.stackabuse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedJava8 {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(10, 23, -4, 0, 18);
		/**
		 * Sorting using Comparator
		 */
		list1.sort(Comparator.naturalOrder());
		System.out.println(list1);
		
		/**
		 * Sorting using stream.sorted
		 */
		List<Integer> list2=list1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(list2);
	}

}
