package com.java.oops.scjp;

public class ParentChild {
	public static void main(String[] args) {
		Parent parent=new Parent();
		parent.m1();// Parent Class Method
		Child child=new Child();
		child.m1();//Parent Class Method
		child.m2();//Child Class Method
		Parent parent1=new Child();
		parent1.m1();//Parent Class Method
		//parent1.m2(); // Compile Time Error
	}
}
