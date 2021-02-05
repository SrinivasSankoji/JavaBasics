package com.jio.javainterview.object;

public class CloneDemo implements Cloneable{
	int i=10;
	int j=20;
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneDemo demo=new CloneDemo();
		CloneDemo demo2=(CloneDemo) demo.clone();
		
		System.out.println(demo==demo2);
		
		demo.i=35;
		demo.j=36;
		System.out.println(demo2.i +" - "+demo2.j);
	}
}
