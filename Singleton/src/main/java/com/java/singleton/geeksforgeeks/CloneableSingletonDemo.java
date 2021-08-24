package com.java.singleton.geeksforgeeks;

public class CloneableSingletonDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableSingleton instanceOne=CloneableSingleton.getInstance();
		CloneableSingleton instanceTwo=(CloneableSingleton)instanceOne.clone();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
