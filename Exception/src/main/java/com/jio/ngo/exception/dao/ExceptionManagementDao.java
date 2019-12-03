package com.jio.ngo.exception.dao;

import java.util.List;

import com.jio.ngo.exception.model.ExceptionByApplication;
import com.jio.ngo.exception.model.ExceptionCountDashBoaard;
import com.jio.ngo.exception.model.ExceptionManagement;

public interface ExceptionManagementDao 
{
	
	List<ExceptionManagement> getSecurityExceptionList();
	
	ExceptionCountDashBoaard getExceptionComplianceScore();
	
	ExceptionManagement updateExceptionManagement(ExceptionManagement exceptionManagement);

	List<ExceptionManagement> getExceptionManagementJpaDetails();

	Integer applicationUpdateByExceptionId(ExceptionManagement exceptionManagement);
	
	void saveuploadSecurityException(List<ExceptionManagement> exceptionManagementDataList);
	
	ExceptionByApplication getHierarchy(String applicationOwner,String application);
	
}
