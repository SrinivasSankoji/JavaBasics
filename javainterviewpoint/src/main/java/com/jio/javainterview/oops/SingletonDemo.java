package com.jio.javainterview.oops;

public class SingletonDemo {
	private static SingletonDemo singleton = null;

	private SingletonDemo() {
		System.out.println("Private Constructor");
	}
	private static SingletonDemo getSingleton() {
		if (singleton == null) {
			singleton = new SingletonDemo();
		}
		return singleton;
	}
	public static void main(String[] args) {

		SingletonDemo demo = singleton.getSingleton();
		SingletonDemo demo1 = singleton.getSingleton();
		System.out.println(demo == demo1);
		System.out.println(demo.equals(demo1));
	}
}
