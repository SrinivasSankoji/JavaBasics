package com.jio.javainterview.object;

public class Dog implements Cloneable{
	int i;
	Cat cat;
	public Dog(int i, Cat cat) {
		super();
		this.i = i;
		this.cat = cat;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
