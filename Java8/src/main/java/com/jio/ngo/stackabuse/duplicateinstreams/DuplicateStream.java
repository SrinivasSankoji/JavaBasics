package com.jio.ngo.stackabuse.duplicateinstreams;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DuplicateStream {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("john", "doe", "doe", "tom", "john");

        /* Eliminate the Duplicate from Stream */
        /*Set<String> result1=stream.collect(Collectors.toSet());
        System.out.println(result1);*/

        /* To get the Duplicate elements Count from the Stream */
        /*Map<String, Integer> result2=stream.collect(Collectors.toMap(Function.identity(), value->1,Integer::sum));
        System.out.println(result2);*/

        /* To get the Duplicate elements from the Stream using Collectors.groupingBy */
        /*List<String>
                result3=stream.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue()>1).map(entry -> entry.getKey()).collect(Collectors.toList());
        System.out.println(result3); // [john, doe]*/

        /* How to fetch the Duplicate Elements from the Stream */
        Set<String> items=new HashSet<>();
        stream.filter(n -> !items.add(n))
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }
}
