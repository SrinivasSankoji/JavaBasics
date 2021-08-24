package com.java.objectclass.scjp;

public class HashCodeDemo {

	public static void main(String[] args) {
		Person person1=new Person();
		person1.setPassword("Bhaumik");
		person1.setConfirmPassword("Bhaumik");
		
		Person person2=new Person();
		person2.setPassword("Bhaumik");
		person2.setConfirmPassword("Bhaumik");
		
		System.out.println("HashCode for Person 1 :"+person1.hashCode());
		System.out.println("HashCode for Person 2 :"+person2.hashCode());
		System.out.println(person1.equals(person2));
	}
	
	
}
