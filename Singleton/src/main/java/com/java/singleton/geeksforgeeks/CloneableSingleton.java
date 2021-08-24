package com.java.singleton.geeksforgeeks;

public class CloneableSingleton implements Cloneable {

	private CloneableSingleton() {
	}

	private static class CloneableSingletonHelper {
		private static final CloneableSingleton INSTANCE = new CloneableSingleton();
	}

	public static CloneableSingleton getInstance() {
		return CloneableSingletonHelper.INSTANCE;
	}

	protected Object clone() throws CloneNotSupportedException {
		//CloneableSingleton cloneableSingleton = (CloneableSingleton) super.clone();
		//return cloneableSingleton;
		return getInstance();
	}
}
