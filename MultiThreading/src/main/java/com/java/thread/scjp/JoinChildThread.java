package com.java.thread.scjp;

public class JoinChildThread extends Thread {
	static Thread mainThread;
	@Override
	public void run(){
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= 5; i++) {
			System.out.println("Child Thread");
		}
	}
}
