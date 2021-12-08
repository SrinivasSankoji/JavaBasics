package com.interfaces.demo;

public class C implements A,B {

	public static void main(String[] args) {
		C c=new C();
		System.out.println(c.draw());// Hello
		System.out.println(B.x);
	}

	@Override
	public String draw() {
		return "Hello";
	}
}
