package com.jio.ngo.defaultmethod;

public interface InterfaceB {
    default void commonMethod() {
        System.out.println("InterfaceB's commonMethod");
    }
}
