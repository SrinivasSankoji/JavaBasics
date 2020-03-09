package com.jio.ngo.javabrains.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private int age;
	
}
