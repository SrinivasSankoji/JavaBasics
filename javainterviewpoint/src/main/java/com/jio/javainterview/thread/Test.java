package com.jio.javainterview.thread;

public class Test {
	public static void main(String[] args) {
		MyThread thread=new MyThread();
		thread.start();
		for (int i = 5; i <= 10; i++) {
			System.out.println(i);
		}
	}
}
