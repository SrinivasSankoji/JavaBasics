package com.java.oops.scjp;

public abstract class AbstractChildDemo extends ChildOverriding {

    /* If the Parent class method is non-abstract then in the Child class it can be overridden as an abstract method.
       Advantage is in the next level child we need to provide implementation.
       Disadvantage is Parent class method is not available to the next level child class.*/
    public abstract void marriage();
}
