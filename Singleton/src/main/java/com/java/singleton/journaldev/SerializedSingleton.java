package com.java.singleton.journaldev;

import java.io.Serializable;

public class SerializedSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private static SerializedSingleton instance = null;

	private SerializedSingleton() {
	}

	public static SerializedSingleton getInstance() {
		if (instance == null) {
			synchronized (SerializedSingleton.class) {
				if (instance == null) {
					instance = new SerializedSingleton();
				}
			}
		}
		return instance;
	}

		//Called during deSerialization
		protected Object readResolve() {
			return getInstance();
		}
}
