package com.jio.ngo.exception.service;

import java.util.List;

import com.jio.ngo.exception.dto.ExceptionManagementRequest;
import com.jio.ngo.exception.model.ExceptionByApplication;
import com.jio.ngo.exception.model.ExceptionCountDashBoaard;
import com.jio.ngo.exception.model.ExceptionManagement;

public interface ExceptionManagementService 
{
	
	void uploadSecurityException(ExceptionManagementRequest riskManagementRequest);
	
	List<ExceptionManagement> getSecurityExceptionList();
	
	ExceptionCountDashBoaard getExceptionCountDashBoaard();
	
	ExceptionCountDashBoaard getExceptionComplianceScore();
	
	ExceptionManagement updateExceptionManagement(ExceptionManagement exceptionManagement);

	Integer applicationUpdateByExceptionId(ExceptionManagement excepMgtReq);
	
	List<ExceptionByApplication> getExceptionByApplication(String userName);
	
	List<String> uploadSecurityExceptionHeader();
}
