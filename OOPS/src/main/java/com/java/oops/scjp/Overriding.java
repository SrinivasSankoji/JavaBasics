package com.java.oops.scjp;

public class Overriding {
	public static void main(String[] args) {

		ParentOverriding parentDemo=new ParentOverriding();
		parentDemo.marriage();//Arranged Marriage
		
		ChildOverriding childDemo=new ChildOverriding();
		childDemo.marriage();//Love Marriage
		
		ParentOverriding parentChild=new ChildOverriding();
		parentChild.marriage();//Love Marriage
		
	}

}
