package com.javainterview.objectcreation;

public class NewInstance {
	String value="hello";
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class cls=Class.forName("com.javainterview.objectcreation.NewInstance");
		NewInstance demo=NewInstance.class.newInstance();
		System.out.println(demo.value);
	}
}
