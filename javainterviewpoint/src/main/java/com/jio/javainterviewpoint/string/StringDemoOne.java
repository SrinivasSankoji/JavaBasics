package com.jio.javainterviewpoint.string;

public class StringDemoOne {
	public static void main(String[] args) {
		String s1=new String("Srinivas");
		String s2=s1.concat(" Chary");
		s1=s1.concat(" Sankoji");
		System.out.println(s1);// Srinivas Sankoji
		System.out.println(s2); // Srinivas Chary
	}
}
