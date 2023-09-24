package com.java.hashmap.javainterviewpoint;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIteration {

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("Cricket", "Sachin");
        hashMap.put("Football", "Zidane");
        hashMap.put("Tennis", "Federer");

        /* Iterate HashMap using EntrySet Iterator While Loop */
        Iterator<Map.Entry<String,String>> iterator=hashMap.entrySet().iterator();
        System.out.println("Inside While Loop Entry Set");
        while (iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Inside For Loop Entry Set ");
        for(Map.Entry entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }
        System.out.println("\n");

        /*Iterate HashMap using KeySet Iterator While Loop */
        Iterator<String> keySetIterator=hashMap.keySet().iterator();
        System.out.println("Inside While Loop Set");
        while (keySetIterator.hasNext()){
            String key=keySetIterator.next();
            System.out.println(key +" - "+hashMap.get(key));
        }

        System.out.println("\n");
        System.out.println("Inside Lambda Expression");
        /* Iterate Hashmap using Lambda Expression */
        hashMap.forEach((key,value) -> System.out.println(key +" - "+value));

        /* Iterate Hashmap using Lambda Expression Entry Set */
        System.out.println("\n");
        System.out.println("Inside Lambda Expression Entry Set ");
        hashMap.entrySet().forEach((entry) -> {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        });


        /* To get only keys from Map */
        System.out.println("\n");
        System.out.println("Only Keys ");
        hashMap.keySet().forEach(System.out::println);

        /* To get only Values from Map */
        System.out.println("\n");
        System.out.println("Only Values ");
        hashMap.values().forEach(System.out::println);

        /* Sort the Map based on Keys */

    }
}
