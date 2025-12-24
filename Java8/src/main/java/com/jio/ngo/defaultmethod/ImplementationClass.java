package com.jio.ngo.defaultmethod;

public class ImplementationClass implements InterfaceA, InterfaceB {
    @Override
    public void commonMethod() {
        System.out.println("ImplementationClass's commonMethod");
    }

    /* Explicitly specify which default method to use */
    public void callInterfaceADefault() {
        InterfaceA.super.commonMethod();
    }

    /* Explicitly specify which default method to use */
    public void callInterfaceBDefault() {
        InterfaceB.super.commonMethod();
    }

    public static void main(String[] args) {
        ImplementationClass obj = new ImplementationClass();
        obj.commonMethod(); // Calls the overridden method in ImplementationClass
        obj.callInterfaceADefault(); // Calls InterfaceA's default method
        obj.callInterfaceBDefault(); // Calls InterfaceB's default method
    }
}
