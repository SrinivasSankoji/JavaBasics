package com.example.demo.behavioral.nullobject;

public class EmailNotifier implements Notifier{
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Sending email with message: " + message);
    }
}
