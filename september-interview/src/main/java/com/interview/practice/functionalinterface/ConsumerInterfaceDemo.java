package com.interview.practice.functionalinterface;

import java.util.function.Consumer;

/* Consumer Interface represents a function that accepts an argument and returns no result*/
public class ConsumerInterfaceDemo {

    static Consumer<String> display=(value -> System.out.println(value));
    public static void main(String[] args) {
        ConsumerInterfaceDemo.display.accept("Welcome to Consumer Interface");
    }
}
