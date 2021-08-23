package com.scjp.durga.dzone;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializingObject {

	public static void main(String[] args) {
		Employee employee=new Employee();
		employee.setName("Srinivas");
		employee.setSalary(87);
		try {
		FileOutputStream fos=new FileOutputStream("employee.ser");
		ObjectOutputStream ois=new ObjectOutputStream(fos);
		ois.writeObject(employee);
		}
		catch (Exception e) {
		}
		System.out.println("Employee Object Serialized Successfully");
	}

}
