package com.java.oops.scjp;

public class OverridingDemo {

	public static void main(String[] args) {

		ParentDemo parentDemo=new ParentDemo();
		parentDemo.marriage();
		
		ChildDemo childDemo=new ChildDemo();
		childDemo.marriage();
		
		ParentDemo parentChild=new ChildDemo();
		parentChild.marriage();
	}

}
