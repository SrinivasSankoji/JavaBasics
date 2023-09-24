package com.java.hashmap.javainterviewpoint;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSorting {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jayant", 80);
        map.put("Abhishek", 90);
        map.put("Anushka", 80);
        map.put("Amit", 75);
        map.put("Danish", 40);

        /* By default,Key Value pairs in TreeMap are sorted in Ascending Order */
        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(map);
        treeMap.forEach((key,value) -> System.out.println(key +" - "+value));



    }
}
