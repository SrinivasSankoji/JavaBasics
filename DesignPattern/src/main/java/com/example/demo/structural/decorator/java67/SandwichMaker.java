package com.example.demo.structural.decorator.java67;

public class SandwichMaker {
    public static void main(String[] args) {
        /* Default Sandwich */
        Sandwich sandwich=new WhiteBreadSandwich("White bread Sandwich");
        System.out.printf("Price of %s is $%.2f %n", sandwich.getDescription(),
                sandwich.price());

        Sandwich cheeseSandwich=new CheeseSandwich(sandwich);
        System.out.printf("Price of %s is $%.2f %n", cheeseSandwich.getDescription(),
                cheeseSandwich.price());

    }
}
