package com.jio.javainterview.classloading;

import java.util.Scanner;

public class LogicTest {

	public static void main(String[] args) {

		try {
			String className="";
			Scanner in =new Scanner(System.in);
			System.out.println("Please Enter Class Name along with package Name");
			className=in.nextLine();
			Class cls=Class.forName(className);
			Object obj=cls.newInstance();
			
			System.out.println(obj.getClass());
		}
		catch (Exception e) {
		}
	}

}
