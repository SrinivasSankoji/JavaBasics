package com.java.exception.scjp;

public class ThrowDemoThree {
    static ArithmeticException exception;//null
    public static void main(String[] args) {
        throw exception; //Null Pointer Exception
    }
}
