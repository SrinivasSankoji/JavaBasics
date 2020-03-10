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
@Table(name = "AUDIT_LOG")
public class AuditLog implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="LOG_ID")
	private Long logId;
	
	@Column(name="IP_ADDRESS")
	private String ipAddress;
	
	@Column(name="RESOURCE_NAME")
	private String resourceName;
	
	@Column(name="LOGIN_DATE")
	private Date loginDate;
	
	@Column(name="USER_ID")
	private Long userId;

}
