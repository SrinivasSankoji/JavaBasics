package com.scjp.durga.dzone;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient int salary;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}
	
	

}
