package com.java.singleton.journaldev;

import java.lang.reflect.Constructor;

public class ReflectionSingleton {

	public static void main(String[] args) {
		LazyInitialization instanceOne = LazyInitialization.getInstance();
		LazyInitialization instanceTwo = null;
		try {
			Constructor<LazyInitialization>[] constructors = (Constructor<LazyInitialization>[]) LazyInitialization.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				instanceTwo=(LazyInitialization) constructor.newInstance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
