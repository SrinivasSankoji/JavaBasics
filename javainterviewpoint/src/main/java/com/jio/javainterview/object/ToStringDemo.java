package com.jio.javainterview.object;

public class ToStringDemo {
	String name;
	int rollno;
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
		return name +"- "+rollno;
	}
	@Override
	public int hashCode() {
		return rollno;
	}
}
