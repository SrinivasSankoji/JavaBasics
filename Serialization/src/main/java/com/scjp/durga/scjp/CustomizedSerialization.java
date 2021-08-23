package com.scjp.durga.scjp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CustomizedSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Cat cat=new Cat();
		System.out.println("Before Serialization ");
		System.out.println(cat.rat.getI());
		
		FileOutputStream fos=new FileOutputStream("Cat.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(cat);
		
		FileInputStream fis=new FileInputStream("Cat.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Cat cat1=(Cat)ois.readObject();
		System.out.println("After Serialization ");
		System.out.println(cat1.rat.getI());
	}

}
