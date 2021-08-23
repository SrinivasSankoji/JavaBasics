package com.java.thread.scjp;

public class SleepDemoThree {
	public static void main(String[] args) {
		SleepDemoTwo three=new SleepDemoTwo();
		three.start();
		//three.interrupt();
		System.out.println("Main Thread End");
	}
}
