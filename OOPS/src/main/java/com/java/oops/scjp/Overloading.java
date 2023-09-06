package com.java.oops.scjp;

public class Overloading {

    public void m1() {
        System.out.println("No Argument Constructor");
    }

    public void m1(int i) {
        System.out.println("Value of Integer Argument is " + i);
    }

    public void m1(double d) {
        System.out.println("Value of Double Argument is " + d);
    }

    public void m1(Object obj) {
        System.out.println("Object Argument");
    }

    public void m1(String string) {
        System.out.println("String Argument");
    }

    public void m1(StringBuffer stringBuffer) {
        System.out.println("StringBuffer Argument");
    }

    public void m1(int... i) {
        System.out.println("Vararg Method with Parameter " + i);
    }

    public static void main(String[] args) {
        Overloading demo = new Overloading();
        demo.m1(); //No Argument Constructor
        demo.m1(36); //  Value of Integer Argument
        demo.m1('a');// Automatic promotion in Overloading
        demo.m1("Srinivas"); // String Argument because Child class will get the Priority
        //demo.m1(null);// CTE if both methods are at same level.
        demo.m1(35, 24); // Vararg Method with Parameter
    }
}
