package com.trigyn.authentication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="USERROLEID")
	private Long userRoleId;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="ROLE_ID")
	private Long roleId;

}
