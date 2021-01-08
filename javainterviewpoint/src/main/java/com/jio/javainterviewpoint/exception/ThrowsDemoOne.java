package com.jio.javainterviewpoint.exception;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ThrowsDemoOne {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter writer=new PrintWriter("abc.txt");
		writer.println("Hello");
	}
}
