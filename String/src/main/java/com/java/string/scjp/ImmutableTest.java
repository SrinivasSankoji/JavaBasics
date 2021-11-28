package com.java.string.scjp;

public class ImmutableTest {

	public static void main(String[] args) {
		Immutable i1=new Immutable(10);
		Immutable i2=i1.modify(10); // If there is no change in the content no new Object will be created and points to the same Object.
		Immutable i3=i2.modify(100);
		System.out.println(i1==i2);
		System.out.println(i2==i3);
		
		System.out.println(i1.modify(5).getI());
		
		final StringBuffer sb=new StringBuffer("Durga");
		sb.append(" Software");
		System.out.println(sb);
		//sb=new StringBuffer("Naresh"); CTE final variables cannot be reassigned.
	}
}
