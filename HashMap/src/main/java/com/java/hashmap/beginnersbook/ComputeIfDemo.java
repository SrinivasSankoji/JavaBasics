package com.java.hashmap.beginnersbook;

import java.util.HashMap;

public class ComputeIfDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("key1", 10000);
		map.put("key2", 55000);
		map.put("key3", 44300);
		map.put("key4", 53200);
		
		System.out.println(map);
		map.computeIfAbsent("key5", key -> 87000);
		
		System.out.println(map);
		
		map.computeIfPresent("key4",(key,val)-> val+1);
		
		System.out.println(map);
	}

}
