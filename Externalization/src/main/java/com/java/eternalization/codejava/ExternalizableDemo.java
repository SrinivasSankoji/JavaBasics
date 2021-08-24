package com.java.eternalization.codejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ExternalizableDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		User user = new User();
		user.setCode(123);
		user.setName("Tom");
		user.setBirthday(new Date());
		user.setPassword("secret123");
		user.setSocialSecurityNumber(1234567890);
	        
		FileOutputStream fos=new FileOutputStream("user.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(user);
		oos.close();
		
		FileInputStream fis=new FileInputStream("user.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		User user1=(User)ois.readObject();
		ois.close();
		System.out.println(user1.getPassword());
		System.out.println(user1.getSocialSecurityNumber());
	}

}
