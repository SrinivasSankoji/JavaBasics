package com.interview.practice.functionalinterface;

import java.util.function.Supplier;

/* Supplier interface does not accept any argument and returns result */
public class SupplierInterfaceDemo {

    static Supplier<String> fetch=() -> "Get the value from Supplier";
    public static void main(String[] args) {
        System.out.println(SupplierInterfaceDemo.fetch.get());

    }
}
