package com.scjp.durga.scjp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cat implements Serializable {

	private static final long serialVersionUID = 1L;

	transient Rat rat = new Rat();

	private void writeObject(ObjectOutputStream oos) throws IOException {
		int x = rat.getI();
		oos.writeInt(x);
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		int x = ois.readInt();
		rat = new Rat();
		rat.setI(x);
	}
}
