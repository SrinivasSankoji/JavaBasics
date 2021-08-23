package com.java.oops.scjp;

public class ParentChild {
	public static void main(String[] args) {
		Parent parent=new Parent();
		parent.m1();
		Child child=new Child();
		child.m1();
		child.m2();
		Parent parent1=new Child();
		parent1.m1();
		//parent1.m2(); // Compile Time Error
	}
}
