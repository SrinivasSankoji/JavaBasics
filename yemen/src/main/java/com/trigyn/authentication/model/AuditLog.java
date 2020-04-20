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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "AUDIT_LOG",schema = "yemen")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AuditLog implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDIT_SEQ")
    @SequenceGenerator(sequenceName = "AUDIT_LOG_SEQ", allocationSize = 1, name = "AUDIT_SEQ")
	@Column(name="\"LOG_ID\"")
	private Long logId;
	
	@Column(name="\"IP_ADDRESS\"")
	private String ipAddress;
	
	@Column(name="\"RESOURCE_NAME\"")
	private String resourceName;
	
	@Column(name="\"LOGIN_DATE\"")
	@CreationTimestamp
	private Date loginDate;
	
	@Column(name="\"USER_ID\"")
	private Long userId;

}
