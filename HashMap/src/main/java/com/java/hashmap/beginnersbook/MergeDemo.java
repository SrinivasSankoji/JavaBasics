package com.java.hashmap.beginnersbook;

import java.util.HashMap;
import java.util.Map;

public class MergeDemo {

	public static void main(String[] args) {

		/**
		 * Merge to sum the Values
		 */
		Map<String,Integer> map1=new HashMap<>();
		map1.put("One", 22);
		map1.put("Two", 27);
		
		Map<String,Integer> map2=new HashMap<>();
		map2.put("One", 23);
		map2.put("Three", 15);

		map2.forEach((key,value) -> map1.merge(key, value, (v1,v2) -> v1+v2));
		System.out.println(map1);
		
		
	}

}
