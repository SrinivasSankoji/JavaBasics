package com.jio.javainterviewpoint.string;

public class StringDemoTwo {
	public static void main(String[] args) {
		String s1=new String("Summer");
		s1.concat("Winter");
		String s2=s1.concat("Spring");
		s1=s1+"fall";
		System.out.println(s1);// Summerfall
		System.out.println(s2);//SummerSpring
	}
}
