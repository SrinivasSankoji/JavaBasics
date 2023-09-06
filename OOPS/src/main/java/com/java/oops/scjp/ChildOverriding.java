package com.java.oops.scjp;

public class ChildOverriding extends ParentOverriding {
    public void marriage() {
        System.out.println("Love Marriage");
    }

    private void personal() {
        System.out.println("Property");
    }
	/* Parent class final methods cannot be overridden */
    /*public void drink() {
        System.out.println("Property");
    }*/

}
