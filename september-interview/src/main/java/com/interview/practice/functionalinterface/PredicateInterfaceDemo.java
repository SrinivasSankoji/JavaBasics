package com.interview.practice.functionalinterface;

import java.util.function.Predicate;

/* Predicate Interface represents a function that accepts one argument and returns either true or false*/
public class PredicateInterfaceDemo {
    static Predicate<String> nullCheck = (value -> value != null && value != "");

    public static void main(String[] args) {
        boolean result = PredicateInterfaceDemo.nullCheck.test("");
        System.out.println(result);
    }
}
