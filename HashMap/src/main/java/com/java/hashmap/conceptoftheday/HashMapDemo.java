package com.java.hashmap.conceptoftheday;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		
		//Creating HashMap with default Capacity and Load Factor
		HashMap<String, String> map1=new HashMap<>();
		
		//Creating HashMap with Capacity 
		HashMap<String, String> map2=new HashMap<>(32);
		
		//Creating HashMap with Capacity and Load Factor
		HashMap<String, String> map3=new HashMap<>(12,0.5f);
		
		//Adding values to the HashMap
		map1.put("ONE", "1");
        map1.put("TWO", "2");
        map1.put("THREE", "3");
        map1.put("FOUR", "4");
        map1.put("FIVE", "5");
        
        //Add the Key Value only If the Key is not Present
        map1.putIfAbsent("ONE","11");
        
        //To retrieve a value associated with the given Key
        System.out.println(map1.get("FIVE"));
        
        //To check particular Key exists in the Map
        System.out.println("Key is Present : "+map1.containsKey("THREE"));
        
        //To find out the number of Key Value pairs in the Map
        System.out.println("Total Size is "+map1.size());
        
       //To clear or remove all the entries from the Map
        //map1.clear();
        
       // To retrieve all the Keys present in the Map
        Set<String> keys=map1.keySet();
        keys.forEach(key -> System.out.println("Keys are "+key));
        
        //To retrieve all the Values in the Map
        Collection<String> values=map1.values();
        values.stream().forEach(System.out::println);
        
        //To retrieve key value pair in the Map
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println("Key "+entry.getKey() +" And Value "+entry.getValue());
		}
		
		//To remove the Key value pair from the Map
		map1.remove("FIVE");
		
		//Remove the Key Value Only If the Value is Mapped
		map1.remove("ONE", "2");
		
		//To replace the Value
		map1.replace("ONE","ONE");
		
		//To replace the Value associated with the Key Only If the Key is Mapped
		map1.replace("ONE","ONE","1");
		
		//To get the Synchronized HashMap
		Map<String,String> synchronizedMap=Collections.synchronizedMap(map1);
	}
}
