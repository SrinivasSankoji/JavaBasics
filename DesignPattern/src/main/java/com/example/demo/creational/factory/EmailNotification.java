package com.example.demo.creational.factory;

public class EmailNotification implements Notification{
	@Override
	public void notifyUser() {
		System.out.println("Sending an Email notification");
	}
}
