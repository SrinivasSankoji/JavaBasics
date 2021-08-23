package com.java.generics.scjp;

import java.util.ArrayList;

public class GenericMethodDemo {
	public static void main(String[] args) {
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("A");
		l1.add("B");
		l1.add("C");
		l1.add("D");
		m1(l1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(10);
		l2.add(20);
		l2.add(30);
		l2.add(40);
		m1(l2);
	}
	public static void m1(ArrayList<?> l)
	{
		//l.add("D");
		l.add(null);
		l.remove(1);
		System.out.println(l);
	}
}
