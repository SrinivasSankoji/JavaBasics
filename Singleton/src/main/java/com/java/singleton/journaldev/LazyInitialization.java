package com.java.singleton.journaldev;

public class LazyInitialization {

	private static LazyInitialization instance;

	private LazyInitialization() {
	}

	public static LazyInitialization getInstance() {
		if (instance == null) {
			synchronized (LazyInitialization.class) {
				if (instance == null) {
					return new LazyInitialization();
				}
			}
		}
		return instance;
	}
}
