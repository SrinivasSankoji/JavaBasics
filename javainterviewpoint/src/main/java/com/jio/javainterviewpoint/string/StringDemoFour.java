package com.jio.javainterviewpoint.string;

public class StringDemoFour {
	public static void main(String[] args) {
		String s1=new String("Chary");
		String s2=s1;//true
		String s3=s1.intern();
		System.out.println(s1==s2);//true
		System.out.println(s1==s3);//false
	}
}
