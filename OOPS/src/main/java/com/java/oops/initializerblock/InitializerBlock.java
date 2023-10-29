package com.java.oops.initializerblock;

public class InitializerBlock {
    int speed;
    {
        speed=80;
    }
    InitializerBlock(){
        System.out.println("Speed of car : "+speed);
    }
    public static void main(String[] args) {
        InitializerBlock block1=new InitializerBlock();
        InitializerBlock block2=new InitializerBlock();
    }
}
