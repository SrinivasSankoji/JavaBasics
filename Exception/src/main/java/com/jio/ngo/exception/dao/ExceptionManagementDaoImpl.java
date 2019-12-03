package com.jio.ngo.exception.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jio.ngo.exception.constant.ExceptionManagementConstant;
import com.jio.ngo.exception.model.ExceptionByApplication;
import com.jio.ngo.exception.model.ExceptionCountDashBoaard;
import com.jio.ngo.exception.model.ExceptionManagement;
import com.jio.ngo.exception.model.ExceptionManagementHistory;
import com.jio.ngo.exception.repository.ExceptionManagementHistoryRepository;
import com.jio.ngo.exception.repository.ExceptionManagementRepository;

@Repository
@Transactional(value="databaseTransactionManager")
public class ExceptionManagementDaoImpl implements ExceptionManagementDao
{
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionManagementDaoImpl.class);
	
	@Autowired
	ExceptionManagementRepository exceptionManagementRepository;
	
	@Autowired
	ExceptionManagementHistoryRepository exceptionManagementHistoryRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	@Qualifier("topsSecurityJdbcTemplate")
	private JdbcTemplate topsSecurityJdbcTemplate;
	
	@Override
	public void saveuploadSecurityException(List<ExceptionManagement> exceptionManagementResultList) 
	{
		List<ExceptionManagement> changeInExpiryDateList=exceptionManagementResultList.stream()
		.filter(exception -> exception.getChangeInExpiryDate()!=null)
		.filter(exception -> exception.getChangeInExpiryDate().equalsIgnoreCase("CHANGEINEXPIRYDATE"))
		.collect(Collectors.toList());
		List<ExceptionManagement> changeInOwnerNameList=exceptionManagementResultList.stream()
		.filter(exception -> exception.getChangeInOwnerName()!=null)
		.filter(exception -> exception.getChangeInOwnerName().equalsIgnoreCase("CHANGEINOWNERNAME"))
		.collect(Collectors.toList());
		List<ExceptionManagement> newRecordList=exceptionManagementResultList.stream()
		.filter(exception -> exception.getIsNewRecord()!=null)
		.filter(exception -> exception.getIsNewRecord().equalsIgnoreCase("NEWRECORD"))
		.collect(Collectors.toList());
		if(!changeInExpiryDateList.isEmpty()) 
		{
			updateAndSaveExceptionHistoryDueDate(changeInExpiryDateList);
		}
		if(!changeInOwnerNameList.isEmpty()) 
		{
			updateAndSaveExceptionHistoryOwnerName(changeInOwnerNameList);
		}
		if(!newRecordList.isEmpty()) 
		{
			saveException(newRecordList);
		}
	}

	@Override
	public List<ExceptionManagement> getSecurityExceptionList() 
	{
		long startTime=System.currentTimeMillis();
		String hql = ExceptionManagementConstant.securityExceptionList;
		RowMapper<ExceptionManagement> rowMapper = new BeanPropertyRowMapper<ExceptionManagement>(ExceptionManagement.class);
		List<ExceptionManagement> exceptionManagementList = topsSecurityJdbcTemplate.query(hql, rowMapper);
		logger.info("getSecurityExceptionDashBoard() Query Executed in "+(System.currentTimeMillis()-startTime) +" Seconds");
		return exceptionManagementList;
	}
	
	@Override
	public List<ExceptionManagement> getExceptionManagementJpaDetails() 
	{
		long startTime=System.currentTimeMillis();
		List<ExceptionManagement> exceptionManagementList=exceptionManagementRepository.findAll();
		logger.info("getExceptionManagementDetails() Query Executed in "+(System.currentTimeMillis()-startTime) +" Seconds");
		return exceptionManagementList;
	}

	@Override
	public ExceptionCountDashBoaard getExceptionComplianceScore() 
	{
		return ExceptionCountDashBoaard.builder().complianceScore(0).build();
	}
	
	private void saveException(List<ExceptionManagement> newRecordList) 
	{
		for (ExceptionManagement exceptionManagement : newRecordList) 
		{
			exceptionManagement.setChangeInOwnerName(exceptionManagement.getIsNewRecord());
			exceptionManagement.setChangeInExpiryDate(exceptionManagement.getIsNewRecord());
			exceptionManagement.setIsNewRecord(exceptionManagement.getIsNewRecord());
			exceptionManagementRepository.save(exceptionManagement);
		}
	}

	private void updateAndSaveExceptionHistoryDueDate(List<ExceptionManagement> changeInExpiryDateList) 
	{
		for (ExceptionManagement exceptionManagement : changeInExpiryDateList) {
			ExceptionManagementHistory exceptionManagementHistory = ExceptionManagementHistory.builder()
			.securityExceptionid(exceptionManagement.getSecurityExceptionid())
			.previousDueDate(exceptionManagement.getPreviousDueDate())
			.extendedDueDate(exceptionManagement.getExtendedDueDate())
			.duedateChangedOn(exceptionManagement.getDuedateChangedOn()).build();
			ExceptionManagement exception = exceptionManagementRepository
			.findByExceptionId(exceptionManagement.getExceptionId());
			exception.setExceptionExpiryDate(exceptionManagement.getExceptionExpiryDate());
			exception.setSubmissionDate(exceptionManagement.getSubmissionDate());
			exception.setChangeInOwnerName(exceptionManagement.getChangeInExpiryDate());
			exception.setChangeInExpiryDate(exceptionManagement.getChangeInExpiryDate());
			exception.setIsNewRecord(exceptionManagement.getChangeInExpiryDate());
			exceptionManagementRepository.save(exception);
			exceptionManagementHistoryRepository.save(exceptionManagementHistory);
		}
	}
	
	private void updateAndSaveExceptionHistoryOwnerName(List<ExceptionManagement> changeInOwnerNameList) 
	{
		for (ExceptionManagement exceptionManagement : changeInOwnerNameList) {
			ExceptionManagementHistory exceptionManagementHistory = ExceptionManagementHistory.builder()
			.securityExceptionid(exceptionManagement.getSecurityExceptionid())
			.previousOwnerName(exceptionManagement.getPreviousOwnerName()).build();
			ExceptionManagement exception = exceptionManagementRepository
			.findByExceptionId(exceptionManagement.getExceptionId());
			exception.setApplicationOwner(exceptionManagement.getApplicationOwner());
			exception.setChangeInOwnerName(exceptionManagement.getChangeInOwnerName());
			exception.setChangeInExpiryDate(exceptionManagement.getChangeInOwnerName());
			exception.setIsNewRecord(exceptionManagement.getChangeInOwnerName());
			exceptionManagementRepository.save(exception);
			exceptionManagementHistoryRepository.save(exceptionManagementHistory);
		}
	}

	@Override
	public ExceptionManagement updateExceptionManagement(ExceptionManagement exceptionManagement) 
	{
		ExceptionManagement exception=exceptionManagementRepository.findByExceptionId(exceptionManagement.getExceptionId());
		exception.setExceptionExpiryDate(exceptionManagement.getExceptionExpiryDate());
		exception.setSubmissionDate(exceptionManagement.getSubmissionDate());
		return entityManager.merge(exception);
	}

	@Override
	public Integer applicationUpdateByExceptionId(ExceptionManagement excepMgtReq) 
	{
		String query = ExceptionManagementConstant.applicationUpdateByExceptionId;
		int result=entityManager.createQuery(query)
		.setParameter(1,excepMgtReq.getBusinessUnit() !=null ? excepMgtReq.getBusinessUnit() : "NA")
		.setParameter(2,excepMgtReq.getDomain() !=null ? excepMgtReq.getDomain() : "NA")
		.setParameter(3,excepMgtReq.getPlatformInAppMaster() !=null ? excepMgtReq.getPlatformInAppMaster() : "NA")
		.setParameter(4,excepMgtReq.getApplicationInAppMaster() !=null ? excepMgtReq.getApplicationInAppMaster() : "NA")
		.setParameter(5,excepMgtReq.getSecurityExceptionid().toUpperCase() !=null ? excepMgtReq.getSecurityExceptionid().toUpperCase() : "NA")
		.executeUpdate();
		return result;
	}

	@Override
	public ExceptionByApplication getHierarchy(String applicationOwner, String application)
	{
		String hql = ExceptionManagementConstant.hierarchy;
		RowMapper<ExceptionByApplication> rowMapper = new BeanPropertyRowMapper<ExceptionByApplication>(ExceptionByApplication.class);	
		ExceptionByApplication exceptionByApplication = topsSecurityJdbcTemplate.queryForObject(hql, rowMapper,applicationOwner,application);
		return exceptionByApplication;
	}

}
