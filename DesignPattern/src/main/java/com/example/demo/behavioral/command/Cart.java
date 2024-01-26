package com.example.demo.behavioral.command;

public class Cart implements Command{
    @Override
    public void execute() {
        System.out.println("Product added to cart");
    }

    @Override
    public void rollback() {
        System.out.println("Product removed from cart");
    }
}
