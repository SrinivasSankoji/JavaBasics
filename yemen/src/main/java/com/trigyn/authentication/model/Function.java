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
@Table(name = "FUNCTION")
public class Function implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FUNCTION_ID")
	private Long functionId;
	
	@Column(name="FUNCTION_NAME")
	private String functionName;
	
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
