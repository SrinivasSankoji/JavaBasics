package com.jio.javainterview.string;

public class StringDemoThree {
	public static void main(String[] args) {
		String s1=new String("You Cannot Chaneg Me");
		String s2=new String("You Cannot Chaneg Me");
		System.out.println(s1==s2); // false
		
		String s3="You Cannot Chaneg Me";
		System.out.println(s1==s3); //false
		
		String s4="You Cannot Chaneg Me";
		System.out.println(s3==s4); //true
		
		String s5="You Cannot"+" Chaneg Me";
		System.out.println(s3==s5); //true
		
		String s6="You Cannot";
		String s7=s6.concat(" Chaneg Me");
		System.out.println(s3==s7); //false
		
		final String s8="You Cannot";
		String s9=s8+" Chaneg Me";
		System.out.println(s3==s9); //true
		
		System.out.println(s6==s8); //true
	}
}
