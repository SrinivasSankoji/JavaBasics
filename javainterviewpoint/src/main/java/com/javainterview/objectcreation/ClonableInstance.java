package com.javainterview.objectcreation;

public class ClonableInstance implements Cloneable {
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		ClonableInstance instanceOne=new ClonableInstance();
		ClonableInstance instanceTwo=(ClonableInstance)instanceOne.clone();
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}
}
