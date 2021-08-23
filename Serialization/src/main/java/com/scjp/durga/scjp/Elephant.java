package com.scjp.durga.scjp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Data;

@Data
public class Elephant extends Animal implements Serializable{

	private static final long serialVersionUID = 1L;
	private int e=27;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Elephant elephant=new Elephant();
		elephant.setA(23);
		System.out.println("Before Serialization ");
		System.out.println(elephant.getA());
		System.out.println(elephant.getE());
		FileOutputStream fos=new FileOutputStream("Elephant.ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(elephant);
		
		FileInputStream fis=new FileInputStream("Elephant.ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Elephant elephant1=(Elephant)ois.readObject();
		System.out.println("After Serialization ");
		System.out.println(elephant1.getA());
		System.out.println(elephant1.getE());
	}

}
