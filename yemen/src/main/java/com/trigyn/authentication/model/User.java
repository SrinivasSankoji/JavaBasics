package com.trigyn.authentication.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class 
 * For the user database table.
 */
@Entity
@Table(name = "USER")
@Data
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="IS_ACTIVE")
	private Integer isActive;
	
	@Column(name="CREATEDON")
	private Date createdOn;
	
	@Column(name="CREATEDBY")
	private String createdBy;
	
	@Column(name="UPDATEDON")
	private Date updatedOn;
	
	@Column(name="UPDATEDBY")
	private Long updateBy;
	
}
