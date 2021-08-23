package com.java.innerclass.material;

public class ThreadDemoOne {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();// Starting Child Thread
		for (int i = 5; i < 10; i++) {
			System.out.println(i);
		}
	}
}
