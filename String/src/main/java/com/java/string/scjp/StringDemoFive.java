package com.java.string.scjp;

public class StringDemoFive {

	public static void main(String[] args) {
		String s1="chary";
		String s2=s1.toUpperCase();
		String s3=s1.toLowerCase();
		String s4=s2.toUpperCase();
		
		System.out.println(s1==s2);//false
		System.out.println(s1==s3);//true
		System.out.println(s2==s4);//true
	}

}
