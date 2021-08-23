package com.java.thread.scjp;

public class RunnableTest {
	public static void main(String[] args) {
		MyRunnable runnable=new MyRunnable();
		Thread t=new Thread(runnable);
		t.start();
	}
}
