package com.example.demo.behavioral.command;

public interface Command {

    void execute();
    void rollback();
}
