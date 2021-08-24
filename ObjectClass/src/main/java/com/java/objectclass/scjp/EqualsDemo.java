package com.java.objectclass.scjp;

public class EqualsDemo {

	String name;
	int rollno;

	public EqualsDemo(String name, int rollno) {
		this.name=name;
		this.rollno=rollno;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rollno;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
		if (obj == null) {
			return false;
		}
		EqualsDemo equalsDemo = (EqualsDemo) obj;

		int rollno2 = equalsDemo.rollno;
		String name2 = equalsDemo.name;

		if (this.name.equals(name2) && this.rollno == rollno2) {
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
