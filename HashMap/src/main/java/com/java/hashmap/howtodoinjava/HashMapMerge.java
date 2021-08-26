package com.java.hashmap.howtodoinjava;

import java.util.HashMap;

public class HashMapMerge {

	public static void main(String[] args) {

		//map 1
		HashMap<Integer, String> map1 = new HashMap<>();
		 
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		map1.put(5, "E");
		 
		//map 2
		HashMap<Integer, String> map2 = new HashMap<>();
		 
		map2.put(1, "G"); 
		map2.put(2, "B");
		map2.put(3, "C");
		map2.put(4, "D");  
		
		//It will override the values which has the same Key
		//map1.putAll(map2);
		
		//Merge the values if Both the Maps has the Same Key
		map2.forEach((key,value) -> map1.merge(key,value, (v1,v2) -> v1.equalsIgnoreCase(v2)?v1:v1+","+v2));
		 
		System.out.println(map1);
	}

}
