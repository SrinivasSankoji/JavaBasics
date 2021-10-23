package com.java.hashmap.howtodoinjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashMapEquals {

	public static void main(String[] args) {
		
		  HashMap<Integer, String> map1 = new HashMap<>();
		  
	        map1.put(1, "A");
	        map1.put(2, "B");
	        map1.put(3, "C");
	         
	        //Same as map1
	        HashMap<Integer, String> map2 = new HashMap<>();
	 
	        map2.put(3, "C");
	        map2.put(1, "A");
	        map2.put(2, "B");
	         
	        //Different from map1
	        HashMap<Integer, String> map3 = new HashMap<>();
	 
	        map3.put(1, "A");
	        map3.put(2, "B");
	        map3.put(3, "C");
	        map3.put(4, "D");
	        
	        //null checking in Map
	        HashMap<Integer, String> map4 = new HashMap<>();
	 
	        map4.put(null, "A");
	        map4.put(2, "B");
	        map4.put(3, "C");
	        map4.put(null, "D");
	        
	        //Compare HashMap with Key-Value Pairs
	        System.out.println(map1.equals(map2));  //true
	        System.out.println(map1.equals(map3));  //false
	        
	       //Compare HashMap with Key's
	        System.out.println(map1.keySet().equals(map2.keySet())); //true
	        System.out.println(map1.keySet().equals(map3.keySet())); //false
	        
	        //Compare HashMap with Values - Duplicates are allowed
	        System.out.println(new ArrayList<>(map1.values()).equals(new ArrayList<>(map2.values()))); // false
	        System.out.println(new ArrayList<>(map1.values()).equals(new ArrayList<>(map3.values()))); //false
	        
	        //Compare HashMap with Values - Duplicates are Not allowed
	        System.out.println(new HashSet<>(map1.values()).equals(new HashSet<>(map2.values()))); //true
	        System.out.println(new HashSet<>(map1.values()).equals(new HashSet<>(map3.values()))); //false
	        
	        //null checking in Map
	        System.out.println(map4);
	        
	}

}
