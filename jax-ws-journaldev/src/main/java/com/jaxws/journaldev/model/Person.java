package com.jaxws.journaldev.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private int id;

}
