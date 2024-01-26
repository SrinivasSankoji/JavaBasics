package com.example.demo.behavioral.command;

import java.util.ArrayList;
import java.util.List;

public class CommandDemo {

    public static void main(String[] args) {
        List<Command> commandHistory = new ArrayList<>();
        Command cart = new Cart();
        commandHistory.add(cart);
        Invoker invoker = new Invoker(cart);
        invoker.executeCommand();
    }
}
