package com.example.demo.behavioral.command;

public class Payment implements Command{
    @Override
    public void execute() {
        System.out.println("Payment received");
    }

    @Override
    public void rollback() {
        System.out.println("Payment reverted");
    }
}
