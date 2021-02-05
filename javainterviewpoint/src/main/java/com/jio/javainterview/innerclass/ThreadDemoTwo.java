package com.jio.javainterview.innerclass;

public class ThreadDemoTwo {
	public static void main(String[] args) {
		Thread t = new Thread() {
			@Override
			public void run() {
				for (int i = 5; i < 10; i++) {
					System.out.println(i);
				}
			}
		};
		t.start();
	}
}
