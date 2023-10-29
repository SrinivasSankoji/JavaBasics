package com.example.demo.creational.factory;

public class FactoryDemo {
	public static void main(String[] args) {
		NotificationFactory factory=new NotificationFactory();
		Notification notification=factory.createNotification("SMS");
		notification.notifyUser();
	}
}
