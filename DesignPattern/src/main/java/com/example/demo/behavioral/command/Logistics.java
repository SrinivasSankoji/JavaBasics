package com.example.demo.behavioral.command;

public class Logistics implements Command{
    @Override
    public void execute() {
        System.out.println("Product shipped");
    }

    @Override
    public void rollback() {
        System.out.println("Product dispatched");
    }
}
