package com.jio.javainterviewpoint.innerclass;

public class ThreadDemoThree {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(i);
				}
			}
		}).start();
		
		Runnable runnable = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(i);
			}
		};
		Thread t=new Thread(runnable);
		t.start();
	}
}
