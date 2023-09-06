package com.java.oops.scjp;

public class ParentChild {
	public static void main(String[] args) {
		Parent parent=new Parent();
		parent.m1();// By using Parent Reference we can call Parent Class Method only
		Child child=new Child();
		child.m1();//Parent Class Method
		child.m2();//Child Class Method
		Parent parent1=new Child();
		parent1.m1();//Parent Class Method
		/* By using Parent reference we can call Parent Methods only and child specific methods we cannot call*/
		//parent1.m2(); // Compile Time Error
	}
}
