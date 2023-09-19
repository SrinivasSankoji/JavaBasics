package com.java.oops.constructor;

public class A {

    private A(){
        System.out.println("Hello World!");
    }

    static A getInstance(){
        return new A();
    }
}
