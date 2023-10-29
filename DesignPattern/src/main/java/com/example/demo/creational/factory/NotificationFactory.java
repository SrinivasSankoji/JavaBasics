package com.example.demo.creational.factory;

public class NotificationFactory {
	public Notification createNotification(String channel) {
		if (channel == null || channel == "")
			return null;
		if (channel == "SMS")
			return new SMSNotification();
		if (channel == "Email")
			return new EmailNotification();
		if (channel == "Push")
			return new PushNotification();
		return null;
	}
}
