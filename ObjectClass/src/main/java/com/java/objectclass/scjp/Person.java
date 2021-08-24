package com.java.objectclass.scjp;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String password;
	private String confirmPassword;

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		return prime * result + (password == null ? 0 : password.hashCode());
	}
	
	public boolean equals(Object object)
	{
		if (object == null || object.getClass() != this.getClass())
			return false;
		Person person = (Person) object;
		return person.getPassword() == this.getPassword();
	}

}
