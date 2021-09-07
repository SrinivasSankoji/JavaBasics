package com.java.arraylist.javabrahman;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer age;

	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (!(object instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) object;
		return employee.getName().equals(this.name) && this.age == employee.getAge();
	}
	
	public int hashCode() {
		int hash = 1;
		int prime = 31;
		hash = hash * prime + this.name.hashCode();
		hash = hash * prime + this.age;
		return hash;
	}
}
