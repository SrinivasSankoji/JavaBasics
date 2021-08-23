package com.java.singleton.journaldev;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializedSingletonDemo {

	public static void main(String[] args) {
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();

		try {
			FileOutputStream fos = new FileOutputStream("Singleton.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceOne);
			oos.close();
			
			FileInputStream fis=new FileInputStream("Singleton.ser");
			ObjectInputStream ois=new ObjectInputStream(fis);
			SerializedSingleton instanceTwo=(SerializedSingleton)ois.readObject();
			
			System.out.println(instanceOne.hashCode());
			System.out.println(instanceTwo.hashCode());
		} catch (Exception e) {
		}
	}

}
