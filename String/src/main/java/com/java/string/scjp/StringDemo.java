package com.java.string.scjp;

public class StringDemo {
	public static void main(String[] args) {
		String s1=new String("Chary");
		String s2=new String("Chary");
		s1.concat("Software");
		System.out.println(s1); //Chary
		System.out.println(s1==s2);//false
		System.out.println(s1.equals(s2));//true
		
		StringBuffer s3=new StringBuffer("Chary");
		StringBuffer s4=new StringBuffer("Chary");
		s3.append("Software");
		System.out.println(s3);//CharySoftware
		System.out.println(s3==s4);//false
		System.out.println(s3.equals(s4));//false
		
		String s5="Chary1";
		System.out.println(s5);
	}
}
