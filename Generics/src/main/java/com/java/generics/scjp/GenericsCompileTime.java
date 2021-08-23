package com.java.generics.scjp;

import java.util.ArrayList;

public class GenericsCompileTime {
	public static void main(String[] args) {
		ArrayList<String> a1=new ArrayList<String>();
		a1.add("Bhaumik");
		a1.add("Nandini");
		a1.add("Srinivas");
		//a1.add(10);
		m1(a1);
		System.out.println(a1);
	}
	public static void m1(ArrayList l)
	{
		l.add(10);
	}
}
