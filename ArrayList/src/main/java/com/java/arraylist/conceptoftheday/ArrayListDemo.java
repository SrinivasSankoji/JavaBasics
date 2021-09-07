package com.java.arraylist.conceptoftheday;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<String> a1=new ArrayList<String>();  // Initial Capacity 10
		ArrayList<String> a2=new ArrayList<String>(20); // Supplied Capacity
		ArrayList<String> a3=new ArrayList<String>(a1); //ArrayList from another ArrayList
		
		//To increase the Capacity of the ArrayList
		a1.ensureCapacity(30);
		
		a1.add("ONE");
		a1.add("TWO");
		a1.add("THREE");
		a1.add("FOUR");
		
		//To decrease the Capacity of the ArrayList
		a1.trimToSize(); //Size reduces to 4
		System.out.println(a1.size());
		
		
	}

}
