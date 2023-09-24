package com.java.hashmap.techiedelight;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public static void main(String[] args) {
        Map<String, Integer> persons = new HashMap<>();
        persons.put("Srinivas", 38);
        persons.put("Nandini", 32);
        persons.put("Bhaumik", 8);

        /* Sum all the Values in the Map using Streams */
        Integer result1=persons.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(result1);

        /* Sum all the values in the Map using reduce */
        persons.put("Aadvik", 3);
        Integer result2=persons.values().stream().reduce(0,Integer::sum);
        System.out.println(result2);
    }
}
