package com.example.demo.behavioral.command;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        this.command.execute();
    }

    public void rollbackCommand() {
        this.command.rollback();
    }
}
