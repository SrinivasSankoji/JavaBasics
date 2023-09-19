package com.interview.practice.functionalinterface;

import java.util.function.Function;

/* Function Interface represents a function that accepts one argument and return another argument */
public class FunctionInterfaceDemo {
    /* Function Interface implementation is now inlined in the declaration of same variable rather in separate class*/
    static Function<Integer, Integer> sum = (value -> value * value);

    public static void main(String[] args) {
        int result = FunctionInterfaceDemo.sum.apply(8);
        System.out.println(result);
    }
}
