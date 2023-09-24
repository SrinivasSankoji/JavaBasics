package com.java.hashmap.howtodoinjava;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorting {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);

        /* Sort the Keys in Ascending Order using Java 8 */
        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));
        System.out.println(sortedMap);




    }
}
