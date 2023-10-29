package com.java.oops.staticblock;

public class StaticBlock {
    static int i;
    int j;

    static {
        i = 10;
        System.out.println("Executing static block");
    }

    StaticBlock() {
        System.out.println("Static Block Constructor");
    }

    public static void main(String[] args) {
        StaticBlock block1 = new StaticBlock();
        StaticBlock block2 = new StaticBlock();
    }
}
