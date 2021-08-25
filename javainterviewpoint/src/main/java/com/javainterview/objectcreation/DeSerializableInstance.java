package com.javainterview.objectcreation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeSerializableInstance {
	public static void main(String[] args) {
		User user=new User();
		user.setName("Srinivas");
		user.setId(36);
		try {
			FileOutputStream fos=new FileOutputStream("user.ser");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
			
			FileInputStream fis=new FileInputStream("user.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			User user2=(User)ois.readObject();
			ois.close();
			
			System.out.println(user.hashCode());
			System.out.println(user2.hashCode());
		}
		catch (Exception e) {
		}
	}
}
