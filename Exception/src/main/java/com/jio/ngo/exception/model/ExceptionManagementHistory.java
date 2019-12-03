package com.jio.ngo.exception.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder=true)
@Table(name="TOPS_THREAT_EXCEPTION_HISTORY")
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionManagementHistory implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXCEPTION_HISTORY_SEQ")
    @SequenceGenerator(sequenceName = "THREAT_EXCEPTION_HISTORY_SEQ", allocationSize = 1, name = "EXCEPTION_HISTORY_SEQ")
	private long exceptionHistoryId;
	
	@Column(name="SECURITYEXCEPTIONID")
	private String securityExceptionid;
	
	@Column(name="PREVIOUS_DUEDATE")
	private String previousDueDate;
	
	@Column(name="EXTENDED_DUEDATE")
	private String extendedDueDate;
	
	@Column(name="DUEDATE_CHANGEDON")
	private String duedateChangedOn;
	
	@Column(name="PREVIOUS_OWNERNAME")
	private String previousOwnerName;
	
	@Transient
	private String changeInExpiryDate;
	
	@Transient
	private String changeInOwnerName;
}
