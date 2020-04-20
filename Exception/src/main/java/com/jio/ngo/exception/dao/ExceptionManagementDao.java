<<<<<<< HEAD
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
=======
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
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
