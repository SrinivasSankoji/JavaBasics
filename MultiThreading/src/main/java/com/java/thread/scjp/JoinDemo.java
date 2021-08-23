package com.java.thread.scjp;

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		JoinThread thread = new JoinThread(); // Creation of Child Thread
		thread.start();// Starting Child Thread
		thread.join();//  Calling Thread i. e Main Thread enters into waiting state and gives the chance to Child Thread.
		for (int i = 0; i <= 5; i++) {
			System.out.println("Rama Thread");
		}
	}
}
