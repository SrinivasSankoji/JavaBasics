<<<<<<< HEAD
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
@Table(name="TOPS_THREAT_EXCEPTION")
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionManagement implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXCEPTION_MGT_SEQ")
    @SequenceGenerator(sequenceName = "THREAT_EXCEPTION_MGT_SEQ", allocationSize = 1, name = "EXCEPTION_MGT_SEQ")
	private long exceptionId;
	
	@Column(name="SECURITYEXCEPTIONID")
	private String securityExceptionid;
	
	@Column(name="EXCEPTIONAGAINST")
	private String exceptionAgainst;
	
	@Column(name="REQUESTER")
	private String requester;
	
	@Column(name="REQUESTERSHOD")
	private String requestersHOD;
	
	@Column(name="APPLICATION")
	private String application;
	
	@Column(name="PLATFORM")
	private String platform;
	
	@Column(name="OVERALLSTATUS")
	private String overallStatus;
	
	@Column(name="EXCEPTIONEXPIRYDATE")
	private String exceptionExpiryDate;
	
	@Column(name="SUBMISSIONDATE")
	private String submissionDate;
	
	@Column(name="NUMBEROFEXTENSIONS")
	private int numberOfExtensions;
	
	@Column(name="DAYSTOEXPIRATION")
	private int daysToExpiration;
	
	@Column(name="BUSINESSRELFORSECURITYEXCEP")
	private String businessRelForSecurityExcep;
	
	@Column(name="TECHNICALLIMITATION")
	private String technicalLimitation;
	
	@Column(name="FINDING")
	private String finding;
	
	@Column(name="FINDINGID")
	private String findingId;
	
	@Column(name="RISKDESCRIPTION")
	private String riskDescription;
	
	@Column(name="SEVERITY")
	private String severity;
	
	@Column(name="BUSINESSUNIT")
	private String businessUnit;
	
	@Column(name="DOMAIN")
	private String domain;
	
	@Column(name="PLATFORMINAPPMASTER")
	private String platformInAppMaster;
	
	@Column(name="APPLICATIONINAPPMASTER")
	private String applicationInAppMaster;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="POLICYSTATEMENTID")
	private String policyStatementId;
	
	@Column(name="POLICYSTATEMENT")
	private String policyStatement;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="EXCEPTIONSUBCATEGORY")
	private String exceptionSubcategory;
	
	@Column(name="APPLICATIONOWNER")
	private String applicationOwner;
	
	@Column(name="BUSINESSUNITOWNER")
	private String businessUnitOwner;
	
	@Column(name="DOMAINOWNER")
	private String domainOwner;
	
	@Column(name="PLATFORMOWNER")
	private String platformOwner;
	
	@Column(name="CHANGEINEXPIRYDATE")
	private String changeInExpiryDate;
	
	@Column(name="CHANGEINOWNERNAME")
	private String changeInOwnerName;
	
	@Column(name="ISNEWRECORD")
	private String isNewRecord;
	
	@Transient
	private String previousDueDate;
	
	@Transient
	private String extendedDueDate;
	
	@Transient
	private String duedateChangedOn;
	
	@Transient
	private String previousOwnerName;
}
=======
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
@Table(name="TOPS_THREAT_EXCEPTION")
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionManagement implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXCEPTION_MGT_SEQ")
    @SequenceGenerator(sequenceName = "THREAT_EXCEPTION_MGT_SEQ", allocationSize = 1, name = "EXCEPTION_MGT_SEQ")
	private long exceptionId;
	
	@Column(name="SECURITYEXCEPTIONID")
	private String securityExceptionid;
	
	@Column(name="EXCEPTIONAGAINST")
	private String exceptionAgainst;
	
	@Column(name="REQUESTER")
	private String requester;
	
	@Column(name="REQUESTERSHOD")
	private String requestersHOD;
	
	@Column(name="APPLICATION")
	private String application;
	
	@Column(name="PLATFORM")
	private String platform;
	
	@Column(name="OVERALLSTATUS")
	private String overallStatus;
	
	@Column(name="EXCEPTIONEXPIRYDATE")
	private String exceptionExpiryDate;
	
	@Column(name="SUBMISSIONDATE")
	private String submissionDate;
	
	@Column(name="NUMBEROFEXTENSIONS")
	private int numberOfExtensions;
	
	@Column(name="DAYSTOEXPIRATION")
	private int daysToExpiration;
	
	@Column(name="BUSINESSRELFORSECURITYEXCEP")
	private String businessRelForSecurityExcep;
	
	@Column(name="TECHNICALLIMITATION")
	private String technicalLimitation;
	
	@Column(name="FINDING")
	private String finding;
	
	@Column(name="FINDINGID")
	private String findingId;
	
	@Column(name="RISKDESCRIPTION")
	private String riskDescription;
	
	@Column(name="SEVERITY")
	private String severity;
	
	@Column(name="BUSINESSUNIT")
	private String businessUnit;
	
	@Column(name="DOMAIN")
	private String domain;
	
	@Column(name="PLATFORMINAPPMASTER")
	private String platformInAppMaster;
	
	@Column(name="APPLICATIONINAPPMASTER")
	private String applicationInAppMaster;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="POLICYSTATEMENTID")
	private String policyStatementId;
	
	@Column(name="POLICYSTATEMENT")
	private String policyStatement;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="EXCEPTIONSUBCATEGORY")
	private String exceptionSubcategory;
	
	@Column(name="APPLICATIONOWNER")
	private String applicationOwner;
	
	@Column(name="BUSINESSUNITOWNER")
	private String businessUnitOwner;
	
	@Column(name="DOMAINOWNER")
	private String domainOwner;
	
	@Column(name="PLATFORMOWNER")
	private String platformOwner;
	
	@Column(name="CHANGEINEXPIRYDATE")
	private String changeInExpiryDate;
	
	@Column(name="CHANGEINOWNERNAME")
	private String changeInOwnerName;
	
	@Column(name="ISNEWRECORD")
	private String isNewRecord;
	
	@Transient
	private String previousDueDate;
	
	@Transient
	private String extendedDueDate;
	
	@Transient
	private String duedateChangedOn;
	
	@Transient
	private String previousOwnerName;
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
