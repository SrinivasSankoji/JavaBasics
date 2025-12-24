package com.jio.ngo.defaultmethod;

public interface InterfaceA {
    default void commonMethod() {
        System.out.println("InterfaceA's commonMethod");
    }
}
