package com.java.innerclass.material;

public class MyRunnableDemoTwo {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(i);
				}
			}
		};
		Thread t=new Thread(runnable);
		t.start();
	}
}
