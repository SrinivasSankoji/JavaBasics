package com.jio.javainterview.thread;

public class ThreadConstructor  extends Thread{
	@Override
	public void run() {
		System.out.println("Thread Class Constructor");
	}
	public static void main(String[] args) {
		ThreadConstructor constructor=new ThreadConstructor();
		Thread t=new Thread(constructor);
		t.start();
	}
}
