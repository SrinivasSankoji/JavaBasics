package com.java.hashmap.beginnersbook;

import java.util.HashMap;
import java.util.Map;

/* compute() of HashMap allows us to update the value with the specified key */
/* compute() returns either null or new value along with the key if the key is not present*/
/* compute() returns the update value if the key is present*/
public class ComputeDemo {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<>();
		map.put("One", "Bhaumik");
		map.put("Two", "Aadvik");
		map.compute("One", (key,value)-> value+" Chary");
		map.compute("Two", (key,value)-> value+" Chary");
		System.out.println(map); //{One=Bhaumik Chary, Two=Aadvik Chary}

		/* Compute to sum the Values */
		Map<String,Integer> map1=new HashMap<>();
		map1.put("Two", 23);
		map1.put("One", 15);
		map1.compute("One", (key,value) -> (value == null) ? 1 : value + value);
		System.out.println(map1); //{One=30, Two=23}


	}

}
