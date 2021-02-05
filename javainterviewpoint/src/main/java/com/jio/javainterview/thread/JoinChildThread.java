package com.jio.javainterview.thread;

public class JoinChildThread extends Thread {
	static Thread minThread;
	@Override
	public void run(){
		try {
			minThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 5; i++) {
			System.out.println("Child Thread");
		}
	}
}
