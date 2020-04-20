package com.trigyn.authentication.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Integer isActive;
	private Date createdOn;
	private Long createdBy;
	private Date updatedOn;
	private Long updatedBy;

}
