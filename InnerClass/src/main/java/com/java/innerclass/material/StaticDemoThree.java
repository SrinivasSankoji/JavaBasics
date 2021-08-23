package com.java.innerclass.material;

public class StaticDemoThree {
	int x = 20;
	static int y = 30;
	static class Inner {
		public void m1() {
			//System.out.println(x);// CTE
			System.out.println(y);
		}
	}
	public static void main(String[] args) {
	}
}
