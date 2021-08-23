package com.java.thread.scjp;

public class SleepDemoOne {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i<= 3; i++) {
			System.out.println("Numbers are "+i);
			Thread.sleep(1000);
		}
	}
}
