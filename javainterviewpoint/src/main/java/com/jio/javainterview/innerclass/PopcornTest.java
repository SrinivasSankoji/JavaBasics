package com.jio.javainterview.innerclass;

public class PopcornTest {
	public static void main(String[] args) {
		SubPopcorn subPopcorn = new SubPopcorn() {
			public void taste() {
				System.out.println("Spicy");
			}
		};
		subPopcorn.taste();
	}
}
