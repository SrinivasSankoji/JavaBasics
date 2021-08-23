package com.java.string.scjp;

public class StringDemoSix {

	public static void main(String[] args) {
		String s1="durga";
		String s2=s1.toString();
		String s3="DURGA";
		String s4=s1.toUpperCase();
		String s5=s1.toLowerCase();
		String s6=s5.toLowerCase();
		String s7=s4.toLowerCase();
		String s8=new String("DURGA");
		String s9=new String("durga");
		String s10=s9.toLowerCase();
		
		System.out.println(s1==s2);//true
		System.out.println(s3==s4);//false
	}

}
