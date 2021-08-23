package com.scjp.durga.scjp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DogSerializedDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog dog=new Dog();
		FileOutputStream fos =new FileOutputStream("Dog.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(dog);
		
		FileInputStream fis =new FileInputStream("Dog.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Dog dog1=(Dog)ois.readObject();
		System.out.println(dog1.getI());
		System.out.println(dog1.getJ());
	}
}
