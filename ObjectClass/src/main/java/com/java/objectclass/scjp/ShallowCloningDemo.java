package com.java.objectclass.scjp;

public class ShallowCloningDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cat cat=new Cat(20);
		Dog dog1=new Dog(30,cat);
		//Shallow Cloning
		Dog dog2=(Dog)dog1.clone();
		System.out.println("Original Object Values "+dog2.i +" And " +dog2.cat.j);
		dog2.cat.j=40;
		System.out.println("Cloned Object Values "+dog2.i +" And " +dog2.cat.j);
		System.out.println("Cat Value "+cat.j);
	}
}
