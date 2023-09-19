package com.java.singleton.journaldev;

public class Singleton {
	private Singleton() {
	}
	/* BillPugh Singleton Implementation */
	private static class SingletonHelper {
		private static final Singleton NEW_INSTANCE = new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonHelper.NEW_INSTANCE;
	}
}
