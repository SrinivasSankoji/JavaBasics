package com.jio.javainterview.thread;

public class SleepDemoTwo extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <= 3; i++) {
			System.out.println("Numbers are " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Child Thread got Interrupted");
			}
		}
	}
}
