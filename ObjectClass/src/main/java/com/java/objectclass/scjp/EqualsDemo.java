package com.java.objectclass.scjp;

public class EqualsDemo {

	String name;
	int rollno;

	public EqualsDemo(String name, int rollno) {
		this.name=name;
		this.rollno=rollno;
	}
	@Override
	public boolean equals(Object obj) {
		try {
		int rollno1 = this.rollno;
		String name1 = this.name;

		EqualsDemo equalsDemo = (EqualsDemo) obj;

		int rollno2 = equalsDemo.rollno;
		String name2 = equalsDemo.name;

		if (name1.equals(name2) && rollno1 == rollno2) {
			return true;
			}
		}
		catch (NullPointerException | ClassCastException  e) {
			return false;
		}
		return false;
	}
	public static void main(String[] args) {

		EqualsDemo e1=new EqualsDemo("Bhaumik",23);
		EqualsDemo e2=new EqualsDemo("Bhaumik",23);
		System.out.println(e1.equals(e2));
	}
}
