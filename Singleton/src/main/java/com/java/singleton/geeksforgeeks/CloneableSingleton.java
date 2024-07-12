package com.java.singleton.geeksforgeeks;

public class CloneableSingleton implements Cloneable {

	private CloneableSingleton() {
	}

	/* Bill pugh Singleton Implementation */
	private static class CloneableSingletonHelper {
		private static final CloneableSingleton INSTANCE = new CloneableSingleton();
	}

	public static CloneableSingleton getInstance() {
		return CloneableSingletonHelper.INSTANCE;
	}

	protected Object clone() throws CloneNotSupportedException {
		//return super.clone();
		return getInstance();
	}
}
