package com.java.oops.scjp;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {
        System.out.println("Private Constructor");
    }

    private static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {

        Singleton demo = singleton.getSingleton();
        Singleton demo1 = singleton.getSingleton();
        System.out.println(demo == demo1);
        System.out.println(demo.equals(demo1));
    }
}
