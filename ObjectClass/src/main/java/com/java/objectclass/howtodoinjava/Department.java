package com.java.objectclass.howtodoinjava;

import java.io.Serializable;

import lombok.Data;

@Data
public class Department implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	// Shallow Cloning
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
