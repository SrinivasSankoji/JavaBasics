package com.example.demo.behavioral.command;

public class Order implements Command{
    @Override
    public void execute() {
        System.out.println("Product Ordered");
    }

    @Override
    public void rollback() {
        System.out.println("Order cancelled");
    }
}
