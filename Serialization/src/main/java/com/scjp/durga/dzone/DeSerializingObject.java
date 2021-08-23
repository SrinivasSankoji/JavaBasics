package com.scjp.durga.dzone;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializingObject {
	public static void main(String[] args) {
		Employee employee = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("employee.ser");
			ois = new ObjectInputStream(fis);
			employee = (Employee) ois.readObject();
			System.out.println(employee);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}
}
