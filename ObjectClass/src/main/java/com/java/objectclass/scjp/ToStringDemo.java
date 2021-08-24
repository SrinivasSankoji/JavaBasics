package com.java.objectclass.scjp;

public class ToStringDemo {
	private String name;
	private int rollno;
	public ToStringDemo(String name, int rollno) {
		this.name=name;
		this.rollno=rollno;
	}
	public static void main(String[] args) {
		ToStringDemo demo=new ToStringDemo("Srinivas",36);
		System.out.println(demo);
	}
	@Override
	public String toString() {
		return "Name of the Student is "+name +" And his Rollno is "+rollno;
	}
}
