package com.java.oops.constructor;

public class ConstructorChainingUsingThis {
    /* Default Constructor */
    ConstructorChainingUsingThis(){
        System.out.println("Default Constructor");
    }
    /* Argument Constructor*/
    ConstructorChainingUsingThis(int x){
        this();
        System.out.println("Value of x : "+x);
    }
    /* Parameterized Constructor */
    ConstructorChainingUsingThis(int x,int y){
        this(x);
        System.out.println("Value of x and y : "+x*y);
    }
    public static void main(String[] args) {
        new ConstructorChainingUsingThis(8,10);
    }
}
