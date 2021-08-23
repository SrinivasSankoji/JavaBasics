package com.java.generics.scjp;

public class ArraysDemo {

	public static void main(String[] args) {
		Student[] student=new Student[10];
		student[0]=new Student();
		//student[1]=new Integer
		//student[2]="Bhaumik";
		
		Object[] object=new Object[10];
		object[0]=new Student();
		object[1]=new Integer(10);
		object[2]="Bhaumik";
	}
}
