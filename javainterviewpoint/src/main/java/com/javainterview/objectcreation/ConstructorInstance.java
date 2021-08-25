package com.javainterview.objectcreation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorInstance {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor constructor=ConstructorInstance.class.getDeclaredConstructor();
		ConstructorInstance instance=(ConstructorInstance) constructor.newInstance();
		System.out.println(instance.hashCode());
	}
}
