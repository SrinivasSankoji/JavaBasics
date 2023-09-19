package com.java.arraylist.conceptoftheday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<String> a1=new ArrayList<>();  // Initial Capacity 10
		ArrayList<String> a2=new ArrayList<>(20); // Supplied Capacity
		ArrayList<String> a3=new ArrayList<>(a1); //ArrayList from another ArrayList
		
		/* To increase the Capacity of the ArrayList */
		a1.ensureCapacity(30);
		
		a1.add("ONE");
		a1.add("TWO");
		a1.add("THREE");
		a1.add("FOUR");
		a1.add("TWO");
		
		/* To decrease the Capacity of the ArrayList */
		a1.trimToSize(); //Size reduces to 4
		System.out.println(a1.size());

		/* To get the Last Index of an Array */
		int index=a1.lastIndexOf("ONE");
		System.out.println(index);

		int[] numbers={2,5,7,9,11};
		List<Integer> list=Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
		
		/* To reverse the Elements of an Array List*/
		Collections.reverse(list);
		System.out.println(list);
	}

}
