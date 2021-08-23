package com.java.singleton.journaldev;

public class StaticBlockInitialization {

	private static StaticBlockInitialization instance;
	static {
		try {
			instance = new StaticBlockInitialization();
		} catch (Exception e) {
			System.out.println("Error in static Block Initialization");
		}
	}

	public static StaticBlockInitialization getInstance() {
		return instance;
	}
}
