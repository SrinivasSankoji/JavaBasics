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

@Data
@Entity
@Table(name = "ROLE")
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ROLE_ID")
	private Long roleId;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@Column(name="IS_ACTIVE")
	private Integer isActive;
	
	@Column(name="IS_PRIVILEGED")
	private String isPriviliged;
	
	@Column(name="CREATEDON")
	private Date createdOn;
	
	@Column(name="CREATEDBY")
	private String createdBy;
	
	@Column(name="UPDATEDON")
	private Date updatedOn;
	
	@Column(name="UPDATEDBY")
	private Long updateBy;
	
	

}
