package com.interview.demo.srinivas;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HCL {
	public static void main(String[] args) {
		/**
		 * Sum of the Square of the Given Number
		 */
		String num = "75";
		char[] charArray = num.toCharArray();
		int operator = 0;
		int result = 0;
		for (int i = 0; i < charArray.length; i++) {
			operator++;
			result = result + (int) Math.pow(Integer.valueOf(charArray[i] + ""), operator);
		}
		System.out.println(result);
		
		/**
		 * Sort Map based on Values Java8
		 */
		Map<String, String> map=new HashMap<>();
		map.put("A", "Apple");
		map.put("B", "Ball");
		map.put("C", "Cat");
		map.entrySet().stream().sorted(Map.Entry.<String,String>comparingByValue().reversed()).forEach(System.out::println);
		Map<Object, Object> sortResult=map.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue().reversed())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1,e2)-> e1,LinkedHashMap::new));
		System.out.println(sortResult);
	}
}
