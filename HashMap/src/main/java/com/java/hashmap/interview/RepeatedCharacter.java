package com.java.hashmap.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatedCharacter {
    public static void main(String[] args) {

        /* Program to get the Character Count */
        String str = "dhananjay";
        Map<Character, Long> result = str.chars().mapToObj(c -> (char) c).
                collect(Collectors.toMap(Function.identity(), c -> 1L, Long::sum));
        System.out.println(result);

        /* Program to get the First repeated Character Count */


        /* Program to get the First non-repeated Character Count */

    }
}
