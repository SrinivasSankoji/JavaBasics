package com.java.thread.scjp;

public class JoinChildDemo {
	public static void main(String[] args) {
		JoinChildThread.mainThread=Thread.currentThread();
		JoinChildThread childThread=new JoinChildThread();
		childThread.start();
		for (int i = 0; i <= 5; i++) {
			System.out.println("Main Thread");
		}
	}
}
