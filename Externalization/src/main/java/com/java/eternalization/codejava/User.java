package com.java.eternalization.codejava;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Externalizable{

	private int code;
    private String name;
    private String password;
    private Date birthday;
    private int socialSecurityNumber;
    
    
    
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(code);
		out.writeObject(name);
		out.writeObject("*****");
		out.writeObject(birthday);
		out.writeInt(0);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.code=in.readInt();
		this.name=(String) in.readObject();
		this.password=(String) in.readObject();
		this.birthday=(Date) in.readObject();
		this.socialSecurityNumber=in.readInt();
	}
}
