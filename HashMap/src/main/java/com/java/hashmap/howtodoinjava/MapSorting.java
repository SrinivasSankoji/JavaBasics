package com.java.hashmap.howtodoinjava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {

    public static void main(String[] args) {
        /* Sort the Keys in Ascending Order using Java 8 */
        Map<String, Integer> map = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);
        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));
        System.out.println(sortedMap);

        /* Sort the Values in Ascending Order using Java 8 */
        Map<String, Integer> namesAges = new HashMap<>();
        namesAges.put("Hari", 35);
        namesAges.put("Jhon", 30);
        namesAges.put("Jakey", 50);
        namesAges.put("kane", 45);
        LinkedHashMap<String, Integer> sortedValue= namesAges.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value2, LinkedHashMap::new));
        System.out.println(sortedValue);




    }
}
