package com.example.demo;

public class StringSplit {
	public static void main(String[] args) {
		String strMain = "randomFromList(merchantCode_SIT)";
		String randomFromList = strMain.split("randomFromList")[1];
		String randomFromValue=randomFromList.substring(1, randomFromList.length()-1);
		System.out.println(randomFromValue);
	}
}
