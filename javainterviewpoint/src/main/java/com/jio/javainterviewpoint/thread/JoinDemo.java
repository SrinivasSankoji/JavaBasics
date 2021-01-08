package com.jio.javainterviewpoint.thread;

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		JoinThread thread = new JoinThread(); // Creation of Child Thread
		thread.start();// Starting Child Thread
		thread.join();// Child Thread enters into waiting state and is executed by Main Thread
		for (int i = 0; i <= 5; i++) {
			System.out.println("Rama Thread");
		}
	}
}
