package com.java.oops.scjp;

public class OverridingDemo {

	public static void main(String[] args) {

		ParentDemo parentDemo=new ParentDemo();
		parentDemo.marriage();//Arranged Marriage
		
		ChildDemo childDemo=new ChildDemo();
		childDemo.marriage();//Love Marriage
		
		ParentDemo parentChild=new ChildDemo();
		parentChild.marriage();//Love Marriage
		
	}

}
