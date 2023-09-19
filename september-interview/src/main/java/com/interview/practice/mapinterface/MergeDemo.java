package com.interview.practice.mapinterface;

import java.util.HashMap;
import java.util.Map;

/* merge() can be used to merge multiple mapped values for a given key using mapping function */
public class MergeDemo {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map1.put("One", 1);
        map1.put("Two", 2);

        Map<String, Integer> map2 = new HashMap<String, Integer>();
        map2.put("One", 10);
        map2.put("Two", 20);
        map2.put("Three", 30);

        /* merge() to sum the values based on keys */
        map2.forEach((key,value) -> map1.merge(key,value,(value1,value2)->value1+value2));
        System.out.println(map1);

    }
}
