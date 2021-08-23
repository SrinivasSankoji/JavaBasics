package com.java.objectclass.scjp;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = new String("Chary");
		String s2 = new String("Chary");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		
		StringBuffer s3 = new StringBuffer("Chary");
		StringBuffer s4 = new StringBuffer("Chary");
		System.out.println(s3 == s4);//false
		System.out.println(s3.equals(s4));//false
	}
}
