package com.java.thread.scjp;

public class YieldDemo extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			Thread.yield();
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		YieldDemo yieldDemo=new YieldDemo();
		yieldDemo.start();
		for (int i = 6; i < 10; i++) {
			System.out.println(i);
		}
	}
}
