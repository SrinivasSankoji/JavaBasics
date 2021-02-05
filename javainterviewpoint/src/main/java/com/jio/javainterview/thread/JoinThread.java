package com.jio.javainterview.thread;

public class JoinThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("Seetha Thread");
		}
	}
}
