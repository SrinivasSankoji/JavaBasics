package com.interview.practice.mapinterface;

import java.util.HashMap;
import java.util.Map;

/* compute() of HashMap allows us to update the value with the specified key */
/* compute() returns either null or new value along with the key if the key is not present*/
/* compute() returns the update value if the key is present*/
public class ComputeDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("One", 2);
        map.put("Two", 2);

        map.compute("Three", (key, value) -> value == null ? 1 : value + 1);
        System.out.println(map);



    }
}
