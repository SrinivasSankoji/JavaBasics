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
public class RoleFunction implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ROLEFUNCTIONID")
	private Long roleFunctionId;
	
	@Column(name="ROLE_ID")
	private Long roleId;
	
	@Column(name="FUNCTION_ID")
	private Long functionId;

}
