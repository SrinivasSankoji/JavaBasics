package com.java.innerclass.material;

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
