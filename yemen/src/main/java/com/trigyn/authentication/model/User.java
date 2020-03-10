package com.trigyn.authentication.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class 
 * For the user database table.
 */
@Entity
@Table(name="USERS",schema = "yemen")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "USER_ID_SEQ", allocationSize = 1, name = "USER_SEQ")
	@Column(name="\"USER_ID\"")
	private Long userId;
	
	@Column(name="\"USER_NAME\"")
	private String userName;
	
	@Column(name="\"FIRST_NAME\"")
	private String firstName;
	
	@Column(name="\"LAST_NAME\"")
	private String lastName;
	
	@Column(name="\"PASSWORD\"")
	private String password;
	
	@Column(name="\"EMAIL\"")
	private String email;
	
	@Column(name="\"IS_ACTIVE\"")
	private Integer isActive;
	
	@Column(name="\"CREATEDON\"")
	@CreationTimestamp
	private Date createdOn;
	
	@Column(name="\"CREATEDBY\"")
	private Long createdBy;
	
	@Column(name="\"UPDATEDON\"")
	@UpdateTimestamp
	private Date updatedOn;
	
	@Column(name="\"UPDATEDBY\"")
	private Long updatedBy;
	
}
