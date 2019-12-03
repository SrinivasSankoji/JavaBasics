package com.jio.ngo.exception.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.QueryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.common.NGOResponse;
import com.jio.ngo.exception.dto.DatabaseException;
import com.jio.ngo.exception.dto.ExceptionManagementRequest;
import com.jio.ngo.exception.model.ExceptionByApplication;
import com.jio.ngo.exception.model.ExceptionCountDashBoaard;
import com.jio.ngo.exception.model.ExceptionManagement;
import com.jio.ngo.exception.service.ExceptionManagementService;
import com.jio.ngo.util.NGOUtil;

@RestController
@CrossOrigin(maxAge = 6000)
@RequestMapping("/security/Exception")
public class ExceptionManagementController 
{
	private static final Logger logger=LoggerFactory.getLogger(ExceptionManagementController.class);
	
	@Autowired
	private Environment environment;
	
	
	@Autowired
	ExceptionManagementService exceptionManagementService;
	
	/**
	 * Service To Save
	 * Exception Management 
	 * Details
	 */ 
	@PostMapping("/uploadSecurityException")
	public ResponseEntity<NGOResponse> uploadSecurityException(@Valid @RequestBody ExceptionManagementRequest riskManagementRequest,
			HttpServletRequest request) {
		try{
		exceptionManagementService.uploadSecurityException(riskManagementRequest);
		return NGOUtil.ngoRepsonse(request,ExceptionManagementController.class,null);
		} catch (NoResultException | QueryException | NullPointerException message) {
			logger.info("uploadSecurityExceptionNew() in ExceptionManagementController with Default Error Message : " + message.getMessage());
		throw new DatabaseException(environment.getProperty("excel"));
		} catch (Throwable e) {
			logger.info("uploadSecurityExceptionNew() in ExceptionManagementController with Final Error Message : " + e.getMessage());
		throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service To Get
	 * Security Exception DashBoard  
	 * Details
	 */ 
	@PostMapping("/getSecurityExceptionDashBoard")
	public ResponseEntity<NGOResponse> getSecurityExceptionList(@Valid @RequestBody ExceptionManagementRequest exceptionManagementRequest,
			HttpServletRequest request) {
		try {
			List<ExceptionManagement> exceptionManagementList = exceptionManagementService.getSecurityExceptionList();
			logger.info("getSecurityExceptionList() in ExceptionManagementController with Data : " + exceptionManagementList.size());
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, exceptionManagementList);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("getSecurityExceptionList() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("getSecurityExceptionList() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service To Get
	 * Security Exception DashBoard  
	 * Details
	 */ 
	@PostMapping("/getExceptionCountDashBoaard")
	public ResponseEntity<NGOResponse> getExceptionCountDashBoaard(@Valid @RequestBody ExceptionManagementRequest exceptionManagementRequest,
			HttpServletRequest request) {
		try {
			ExceptionCountDashBoaard exceptionCountDashBoaard = exceptionManagementService.getExceptionCountDashBoaard();
			logger.info("getExceptionCountDashBoaard() in ExceptionManagementController with Data : " + exceptionCountDashBoaard.toString());
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, exceptionCountDashBoaard);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("getExceptionCountDashBoaard() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("getExceptionCountDashBoaard() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service To Get
	 * Security Exception DashBoard  
	 * Details
	 */ 
	@PostMapping("/getExceptionComplianceScore")
	public ResponseEntity<NGOResponse> getExceptionComplianceScore(@Valid @RequestBody ExceptionManagementRequest exceptionManagementRequest,
			HttpServletRequest request) {
		try {
			ExceptionCountDashBoaard exceptionCountDashBoaard = exceptionManagementService.getExceptionComplianceScore();
			logger.info("getExceptionComplianceScore() in ExceptionManagementController with Data : " + exceptionCountDashBoaard);
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, exceptionCountDashBoaard);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("getExceptionComplianceScore() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("getExceptionComplianceScore() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service To Get
	 * Security Exception DashBoard  
	 * Details
	 */ 
	@PostMapping("/getExceptionByApplication")
	public ResponseEntity<NGOResponse> getExceptionByApplication(@Valid @RequestBody ExceptionManagementRequest exceptionManagementRequest,
			HttpServletRequest request) {
		try {
			List<ExceptionByApplication> exceptionByApplicationList=exceptionManagementService.getExceptionByApplication(exceptionManagementRequest.getUserName());
			logger.info("getExceptionByApplication() in ExceptionManagementController with Data : " + exceptionByApplicationList.size());
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, exceptionByApplicationList);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("getExceptionByApplication() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("getExceptionByApplication() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service To Get
	 * Security Exception 
	 * Header Details
	 */ 
	@PostMapping("/uploadSecurityExceptionHeader")
	public ResponseEntity<NGOResponse> uploadSecurityExceptionHeader(@Valid @RequestBody ExceptionManagementRequest exceptionManagementRequest,
			HttpServletRequest request) {
		try {
			List<String> exceptionHeaderList=exceptionManagementService.uploadSecurityExceptionHeader();
			List<List<String>> list=new ArrayList<List<String>>();
			list.add(exceptionHeaderList);
			logger.info("uploadSecurityExceptionHeader() in ExceptionManagementController with Data : " + list.size());
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, list);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("uploadSecurityExceptionHeader() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("uploadSecurityExceptionHeader() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	
	/**
	 * Service to Update 
	 * application related information
	 */
	@RequestMapping(value = "/applicationUpdateByExceptionId", method = RequestMethod.POST)
	public ResponseEntity<NGOResponse> applicationUpdateByExceptionId(@Valid @RequestBody ExceptionManagement excepMgtReq,
			HttpServletRequest request) {
		try {
			int result= Optional.ofNullable(exceptionManagementService.applicationUpdateByExceptionId(excepMgtReq))
			.orElseThrow(() -> new DatabaseException(environment.getProperty("app_Update")));
			logger.info("applicationUpdateByExceptionId() in ExceptionManagementController with Data : " + result);
			return NGOUtil.ngoRepsonse(request, ExceptionManagementController.class, result);
		} catch (NoResultException | QueryException | NullPointerException | DataAccessException message) {
			logger.info("applicationUpdateByExceptionId() in ExceptionManagementController with Error Message : " + message.getMessage());
			throw new DatabaseException(environment.getProperty("daily"));
		} catch (Throwable e) {
			logger.info("applicationUpdateByExceptionId() in ExceptionManagementController with Error Message : " + e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
	}
	

}
