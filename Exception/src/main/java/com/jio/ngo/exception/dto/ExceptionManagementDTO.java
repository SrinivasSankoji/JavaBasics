package com.jio.ngo.exception.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class ExceptionManagementDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private long exceptionId;
	private String application;
	private String applicationInAppMaster;
	private String businessRelForSecurityExcep;
	private String businessUnit;
	private int daysToExpiration;
	private String description;
	private String domain;
	private String exceptionAgainst;
	private String exceptionExpiryDate;
	private String exceptionSubcategory;
	private String finding;
	private String findingId;
	private int numberOfExtensions;
	private String overallStatus;
	private String platform;
	private String platformInAppMaster;
	private String policyStatement;
	private String policyStatementId;
	private String requester;
	private String requestersHOD;
	private String riskDescription;
	private String securityExceptionid;
	private String severity;
	private String status;
	private String submissionDate;
	private String technicalLimitation;
	private String applicationOwner;
	private String businessUnitOwner;
	private String domainOwner;
	private String platformOwner;
	
	//Logical Columns
	private String changeInExpiryDate;
	private String changeInOwnerName;
	private String previousDueDate;
	private String extendedDueDate;
	private String duedateChangedOn;
	private String isNewRecord;
	
	
}
