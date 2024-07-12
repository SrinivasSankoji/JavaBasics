package com.example.demo.behavioral.nullobject;

public class SMSNotifier implements Notifier {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
