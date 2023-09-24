package com.javainterview.objectcreation;

public class CloneableInstance implements Cloneable {
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableInstance instanceOne=new CloneableInstance();
		CloneableInstance instanceTwo=(CloneableInstance)instanceOne.clone();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
