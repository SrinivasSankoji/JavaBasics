package com.javainterview.streamcreation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        /* Create Stream using Of */
        Stream.of("a1", "b2", "c3", "d4").forEach(System.out::println);

        /* Create Stream using iterate */
        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

        /* Create String Stream using Arrays*/
        String[] name = {"Srinivas", "Chary", "Sankoji"};
        List<String> nameList = Arrays.asList(name).stream().map(String::toUpperCase).collect(Collectors.toList());
        // nameList.forEach(System.out::println);


        /* Create Int Stream using int Array*/
        int[] numbers = {9, 8, 7, 6, 5, 4, 7};
        List<Integer> numbersLit = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
        //numbersLit.forEach(System.out::println);

        /* Create Stream using generate */
        Stream<Double> generatedNumbers = Stream.generate(Math::random).limit(10);
        Arrays.stream(generatedNumbers.toArray()).forEach(System.out::println);

    }

}
