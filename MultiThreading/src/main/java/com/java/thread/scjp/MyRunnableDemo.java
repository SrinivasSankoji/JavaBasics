package com.java.thread.scjp;

public class MyRunnableDemo {
	public static void main(String[] args) {
		//MyRunnable runnable=new MyRunnable();
		/* Creating Runnable using Lambda Expression*/
		Runnable runnable= () -> {
			for (int i = 0; i <= 5; i++) {
				System.out.println(i);
			}
		};
		Thread t=new Thread(runnable);
		t.start();
		for (int i = 5; i <= 10; i++) {
			System.out.println(i);
		}
	}
}
