package com.java.objectclass.howtodoinjava;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	private String employeeName;
	private int employeeId;
	private Department department;

	//Shallow Cloning
	/**protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}**/
	
	//Deep Cloning
	protected Object clone() throws CloneNotSupportedException {
		Employee cloned=(Employee)super.clone();
		cloned.setDepartment((Department)cloned.getDepartment().clone());
		return cloned;
	}
}
