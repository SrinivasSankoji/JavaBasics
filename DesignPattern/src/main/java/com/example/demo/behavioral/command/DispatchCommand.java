package com.example.demo.behavioral.command;

public class DispatchCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Product delivered");
    }

    @Override
    public void rollback() {
        System.out.println("Product collected");
    }
}
