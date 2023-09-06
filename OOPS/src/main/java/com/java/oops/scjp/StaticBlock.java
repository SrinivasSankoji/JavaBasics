package com.java.oops.scjp;

public class StaticBlock {
	
	String name;
	int[] i;
	static {
		System.out.println("Without executing Main Method");
	}
	{
		name="Bhaumik Sankoji";
	}
	public static void main(String[] args) {
		StaticBlock staticBlock=new StaticBlock();
		System.out.println(staticBlock.i);
		System.out.println(staticBlock.name);
	}
}
