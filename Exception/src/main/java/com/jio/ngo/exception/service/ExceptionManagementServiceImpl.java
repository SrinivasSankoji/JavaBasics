package com.jio.ngo.exception.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.ngo.exception.dao.ExceptionManagementDao;
import com.jio.ngo.exception.dto.DatabaseException;
import com.jio.ngo.exception.dto.ExceptionManagementDTO;
import com.jio.ngo.exception.dto.ExceptionManagementRequest;
import com.jio.ngo.exception.model.ExceptionByApplication;
import com.jio.ngo.exception.model.ExceptionCountDashBoaard;
import com.jio.ngo.exception.model.ExceptionManagement;

@Service
public class ExceptionManagementServiceImpl implements ExceptionManagementService
{
	
	@Autowired
	ExceptionManagementDao exceptionManagementDao;
	
	@Override
	public void uploadSecurityException(ExceptionManagementRequest riskManagementRequest) 
	{
		List<Object[]> jsonData=riskManagementRequest.getJsonData();
		jsonData.remove(0);
		List<ExceptionManagementDTO> exceptionManagementDataList=convertObjectToList(jsonData);
		List<ExceptionManagement> exceptionManagementResultList=getSecurityExceptionList();
		for (ExceptionManagementDTO exceptionManagementDTO : exceptionManagementDataList) 
		{
			ExceptionManagement exceptionManagement = exceptionManagementResultList.stream()
			.filter(execption -> execption.getSecurityExceptionid()!=null)
			.filter(execption -> exceptionManagementDTO.getSecurityExceptionid()!="NA")
			.filter(execption -> execption.getSecurityExceptionid().trim()
			.equalsIgnoreCase(exceptionManagementDTO.getSecurityExceptionid().trim()))
			.findFirst().orElse(null);
			if (exceptionManagement != null && !exceptionManagementDTO.getExceptionExpiryDate().trim()
					.equalsIgnoreCase(exceptionManagement.getExceptionExpiryDate().trim())) 
			{
				exceptionManagement.setChangeInExpiryDate("CHANGEINEXPIRYDATE");
				exceptionManagement.setExceptionExpiryDate(exceptionManagementDTO.getExceptionExpiryDate());
				exceptionManagement.setPreviousDueDate(exceptionManagement.getExceptionExpiryDate());
				exceptionManagement.setExtendedDueDate(exceptionManagementDTO.getExceptionExpiryDate());
				exceptionManagement.setDuedateChangedOn(exceptionManagementDTO.getSubmissionDate());
				exceptionManagement.setExceptionId(exceptionManagement.getExceptionId());
			}
			if (exceptionManagement != null && !exceptionManagementDTO.getApplicationOwner().trim()
					.equalsIgnoreCase(exceptionManagement.getApplicationOwner()!=null?exceptionManagement.getApplicationOwner().trim():"NA")) 
			{
				exceptionManagement.setChangeInOwnerName("CHANGEINOWNERNAME");
				exceptionManagement.setPreviousOwnerName(exceptionManagement.getApplicationOwner());
				exceptionManagement.setApplicationOwner(exceptionManagementDTO.getApplicationOwner());
				exceptionManagement.setExceptionId(exceptionManagement.getExceptionId());
			}
			if (exceptionManagement == null) 
			{
				exceptionManagement=convertDTO2Model(exceptionManagementDTO);
				exceptionManagementResultList.add(exceptionManagement);
			}
		}
		exceptionManagementDao.saveuploadSecurityException(exceptionManagementResultList);
	}
	
	@Override
	public List<ExceptionManagement> getSecurityExceptionList() 
	{
		return exceptionManagementDao.getSecurityExceptionList();
	}

	@Override
	public ExceptionCountDashBoaard getExceptionCountDashBoaard() 
	{
		List<ExceptionManagement> exceptionManagementList=exceptionManagementDao.getSecurityExceptionList();
		long closedException=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getStatus().equalsIgnoreCase("CLOSED"))
		.count();
		long activeException=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getStatus().equalsIgnoreCase("OPEN"))
		.count();
		List<String> exceptionExpiryDateList=exceptionManagementList.stream()
		.map(exceptionManagement -> exceptionManagement.getExceptionExpiryDate())
		.collect(Collectors.toList());
		List<String> submissionDateList=exceptionManagementList.stream()
		.map(exceptionManagement -> exceptionManagement.getSubmissionDate())
		.collect(Collectors.toList());
		ExceptionCountDashBoaard exceptionByApplicationSubmissionDate=exceptionCountDashBoaardBySubmissionDate(submissionDateList);
		ExceptionCountDashBoaard exceptionByApplicationExpiryDate=exceptionCountDashBoaardByExpiryDate(exceptionExpiryDateList);
		return ExceptionCountDashBoaard.builder()
		.closedException(closedException)
		.activeException(activeException)
		.openSince6Months(exceptionByApplicationExpiryDate.getOpenSince6Months())
		.openSince1Year(exceptionByApplicationExpiryDate.getOpenSince1Year())
		.openSince2Years(exceptionByApplicationExpiryDate.getOpenSince2Years())	
		.dueinNext7Days(exceptionByApplicationSubmissionDate.getDueinNext7Days())
		.dueinNext15Days(exceptionByApplicationSubmissionDate.getDueinNext15Days())
		.dueinNext30Days(exceptionByApplicationSubmissionDate.getDueinNext30Days())
		.build();
	}

	@Override
	public ExceptionCountDashBoaard getExceptionComplianceScore() 
	{
		return exceptionManagementDao.getExceptionComplianceScore();
	}
	
	@Override
	public ExceptionManagement updateExceptionManagement(ExceptionManagement exceptionManagement) 
	{
		return exceptionManagementDao.updateExceptionManagement(exceptionManagement);
	}

	@Override
	public Integer applicationUpdateByExceptionId(ExceptionManagement excepMgtReq) 
	{
		return exceptionManagementDao.applicationUpdateByExceptionId(excepMgtReq);
	}

	@Override
	public List<ExceptionByApplication> getExceptionByApplication(String userName) 
	{
		List<ExceptionManagement> exceptionManagementList = exceptionManagementDao.getSecurityExceptionList();
		 Set<String> applicationOwnerList=getApplicationOwnerList(exceptionManagementList,userName);
		List<ExceptionByApplication> exceptionByApplicationList = new ArrayList<ExceptionByApplication>();
		if(!applicationOwnerList.isEmpty()) {
		for (String applicationOwner : applicationOwnerList) 
		{
			ExceptionByApplication exceptionByApplication=
			getExceptionByApplicationByApplicationOwner(exceptionManagementList,applicationOwner);
			exceptionByApplicationList.add(exceptionByApplication);
		}}
		return exceptionByApplicationList;
	}
	
	@Override
	public List<String> uploadSecurityExceptionHeader() 
	{
		List<String> exceptionHeaderList = Arrays.asList("SECURITYEXCEPTIONID","EXCEPTIONAGAINST","REQUESTER",
		"REQUESTERSHOD","APPLICATION","PLATFORM","OVERALLSTATUS","EXCEPTIONEXPIRYDATE","SUBMISSIONDATE",
		"NUMBEROFEXTENSIONS","DAYSTOEXPIRATION","BUSINESSRELFORSECURITYEXCEP","TECHNICALLIMITATION",
		"FINDINGID","FINDING","RISKDESCRIPTION","SEVERITY","BUSINESSUNIT","DOMAIN","PLATFORMINAPPMATERS",
		"APPLICATIONINAPPMATERS","STATUS","POLICYSTATEMENTID","POLICYSTATEMENT","DESCRIPTION","EXCEPTIONSUBCATEGORY",
		"APPLICATIONOWNER","BUSINESSUNITOWNER","DOMAINOWNER","PLATFORMOWNER");
		return exceptionHeaderList;
	}
	
	private ExceptionManagement convertDTO2Model(ExceptionManagementDTO exceptionManagementDTO) 
	{
		return ExceptionManagement.builder()
		.securityExceptionid(exceptionManagementDTO.getSecurityExceptionid())
		.exceptionAgainst(exceptionManagementDTO.getExceptionAgainst())
		.requester(exceptionManagementDTO.getRequester())
		.requestersHOD(exceptionManagementDTO.getRequestersHOD())
		.application(exceptionManagementDTO.getApplication())
		.platform(exceptionManagementDTO.getPlatform())
		.overallStatus(exceptionManagementDTO.getOverallStatus())
		.exceptionExpiryDate(exceptionManagementDTO.getExceptionExpiryDate())
		.submissionDate(exceptionManagementDTO.getSubmissionDate())
		.numberOfExtensions(exceptionManagementDTO.getNumberOfExtensions())
		.daysToExpiration(exceptionManagementDTO.getDaysToExpiration())
		.businessRelForSecurityExcep(exceptionManagementDTO.getBusinessRelForSecurityExcep())
		.technicalLimitation(exceptionManagementDTO.getTechnicalLimitation())
		.findingId(exceptionManagementDTO.getFindingId())
		.finding(exceptionManagementDTO.getFinding())
		.riskDescription(exceptionManagementDTO.getRiskDescription())
		.severity(exceptionManagementDTO.getSeverity())
		.businessUnit(exceptionManagementDTO.getBusinessUnit())
		.domain(exceptionManagementDTO.getDomain())
		.platformInAppMaster(exceptionManagementDTO.getPlatformInAppMaster())
		.applicationInAppMaster(exceptionManagementDTO.getApplicationInAppMaster())
		.status(exceptionManagementDTO.getStatus())
		.policyStatementId(exceptionManagementDTO.getPolicyStatementId())
		.policyStatement(exceptionManagementDTO.getPolicyStatement())
		.description(exceptionManagementDTO.getDescription())
		.exceptionSubcategory(exceptionManagementDTO.getExceptionSubcategory())
		.applicationOwner(exceptionManagementDTO.getApplicationOwner())
		.isNewRecord("NEWRECORD")
		.build();
	}

	private List<ExceptionManagementDTO> convertObjectToList(List<Object[]> jsonData)
	{
		List<ExceptionManagementDTO> exceptionManagementDataList=new ArrayList<ExceptionManagementDTO>();
		for (Object[] object : jsonData) 
		{
			ExceptionManagementDTO exceptionManagementDTO = ExceptionManagementDTO.builder()
			.securityExceptionid(StringUtils.isNotBlank(String.valueOf(object[0])) ? String.valueOf(object[0]) : "NA")
			.exceptionAgainst(StringUtils.isNotBlank(String.valueOf(object[1])) ? String.valueOf(object[1]) : "NA")
			.requester(StringUtils.isNotBlank(String.valueOf(object[2])) ? String.valueOf(object[2]) : "NA")
			.requestersHOD(StringUtils.isNotBlank(String.valueOf(object[3])) ? String.valueOf(object[3]) : "NA")
			.application(StringUtils.isNotBlank(String.valueOf(object[4])) ? String.valueOf(object[4]) : "NA")
			.platform(StringUtils.isNotBlank(String.valueOf(object[5])) ? String.valueOf(object[5]) : "NA")
			.overallStatus(StringUtils.isNotBlank(String.valueOf(object[6])) ? String.valueOf(object[6]) : "NA")
			.exceptionExpiryDate(StringUtils.isNotBlank(String.valueOf(object[7])) ? String.valueOf(object[7]) : "NA")
			.submissionDate(StringUtils.isNotBlank(String.valueOf(object[8])) ? String.valueOf(object[8]) : "NA")
			.numberOfExtensions(StringUtils.isNumeric(String.valueOf(object[9])) ? Integer.parseInt(String.valueOf(object[9])) :0)
			.daysToExpiration(StringUtils.isNumeric(String.valueOf(object[10])) ? Integer.parseInt(String.valueOf(object[10])) :0)
			.businessRelForSecurityExcep(StringUtils.isNotBlank(String.valueOf(object[11])) ? String.valueOf(object[11]) : "NA")
			.technicalLimitation(StringUtils.isNotBlank(String.valueOf(object[12])) ? String.valueOf(object[12]) : "NA")
			.findingId(StringUtils.isNotBlank(String.valueOf(object[13])) ? String.valueOf(object[13]) : "NA")
			.finding(StringUtils.isNotBlank(String.valueOf(object[14])) ? String.valueOf(object[14]) : "NA")
			.riskDescription(StringUtils.isNotBlank(String.valueOf(object[15])) ? String.valueOf(object[15]) : "NA")
			.severity(StringUtils.isNotBlank(String.valueOf(object[16])) ? String.valueOf(object[16]) : "NA")
			.businessUnit(StringUtils.isNotBlank(String.valueOf(object[17])) ? String.valueOf(object[17]) : "NA")
			.domain(StringUtils.isNotBlank(String.valueOf(object[18])) ? String.valueOf(object[18]) : "NA")
			.platformInAppMaster(StringUtils.isNotBlank(String.valueOf(object[19])) ? String.valueOf(object[19]) : "NA")
			.applicationInAppMaster(StringUtils.isNotBlank(String.valueOf(object[20])) ? String.valueOf(object[20]) : "NA")
			.status(StringUtils.isNotBlank(String.valueOf(object[21])) ? String.valueOf(object[21]) : "NA")
			.policyStatementId(StringUtils.isNotBlank(String.valueOf(object[22])) ? String.valueOf(object[22]) : "NA")
			.policyStatement(StringUtils.isNotBlank(String.valueOf(object[23])) ? String.valueOf(object[23]) : "NA")
			.description(StringUtils.isNotBlank(String.valueOf(object[24])) ? String.valueOf(object[24]) : "NA")
			.exceptionSubcategory(StringUtils.isNotBlank(String.valueOf(object[25])) ? String.valueOf(object[25]) : "NA")
			.applicationOwner(StringUtils.isNotBlank(String.valueOf(object[26])) ? String.valueOf(object[26]) : "NA")
			.businessUnitOwner(StringUtils.isNotBlank(String.valueOf(object[27])) ? String.valueOf(object[27]) : "NA")
			.domainOwner(StringUtils.isNotBlank(String.valueOf(object[28])) ? String.valueOf(object[28]) : "NA")
			.platformOwner(StringUtils.isNotBlank(String.valueOf(object[29])) ? String.valueOf(object[29]) : "NA")
			.build();
			if(exceptionManagementDTO.getSecurityExceptionid().equalsIgnoreCase("NA"))
			{
				throw new DatabaseException("Exception Id Cannot Be Null");
			}
			exceptionManagementDataList.add(exceptionManagementDTO);
		}
		return exceptionManagementDataList;
	}

	private Set<String> getApplicationOwnerList(List<ExceptionManagement> exceptionManagementList,String userName) 
	{
		List<ExceptionManagement> domainOwnerList=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getDomainOwner().equalsIgnoreCase(userName))
		.collect(Collectors.toList());
		if(!domainOwnerList.isEmpty())
		{
			Set<String> applicationOwnerSet=domainOwnerList.stream()
			.map(exceptionManagement -> exceptionManagement.getApplicationOwner())
			.collect(Collectors.toSet());
			return applicationOwnerSet;
		}
		List<ExceptionManagement> platformOwnerList=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getPlatformOwner().equalsIgnoreCase(userName))
		.collect(Collectors.toList());
		if(!platformOwnerList.isEmpty())
		{
			Set<String> applicationOwnerSet=platformOwnerList.stream()
			.map(exceptionManagement -> exceptionManagement.getApplicationOwner())
			.collect(Collectors.toSet());
			return applicationOwnerSet;
		}
		ExceptionManagement exceptionManagementObject=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getApplicationOwner().equalsIgnoreCase(userName))
		.findFirst().orElse(null);
		if(exceptionManagementObject!=null)
		{
			Set<String> applicationOwnerSet=exceptionManagementList.stream()
			.filter(exceptionManagement -> exceptionManagement.getApplicationOwner().equalsIgnoreCase(userName))
			.map(exceptionManagement -> exceptionManagement.getApplicationOwner())
			.collect(Collectors.toSet());
			return applicationOwnerSet;
		}
		return Collections.<String>emptySet();
		
	}

	private ExceptionByApplication getExceptionByApplicationByApplicationOwner(List<ExceptionManagement> exceptionManagementList,String ownerName) 
	{
		List<String> exceptionExpiryDateList=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getApplicationOwner().equalsIgnoreCase(ownerName))
		.map(exceptionManagement -> exceptionManagement.getExceptionExpiryDate())
		.collect(Collectors.toList());
		List<String> submissionDateList=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getApplicationOwner().equalsIgnoreCase(ownerName))
		.map(exceptionManagement -> exceptionManagement.getSubmissionDate())
		.collect(Collectors.toList());
		ExceptionManagement exceptionManagementObject=exceptionManagementList.stream()
		.filter(exceptionManagement -> exceptionManagement.getApplicationOwner().equalsIgnoreCase(ownerName))
		.findFirst().orElse(null);
		ExceptionByApplication exceptionByApplicationSubmissionDate=calculateExceptionByApplicationSubmissionDate(submissionDateList);
		ExceptionByApplication exceptionByApplicationExpiryDate=calculateExceptionByApplicationExpiryDate(exceptionExpiryDateList);
		ExceptionByApplication exceptionByApplication=ExceptionByApplication.builder()
		.lessThan3Month(exceptionByApplicationSubmissionDate.getLessThan3Month())
		.threeTo6Month(exceptionByApplicationSubmissionDate.getThreeTo6Month())
		.sixTo12Month(exceptionByApplicationSubmissionDate.getSixTo12Month())
		.twelveTo24Month(exceptionByApplicationSubmissionDate.getTwelveTo24Month())
		.greaterThan24Month(exceptionByApplicationSubmissionDate.getGreaterThan24Month())
		.lessThan7Days(exceptionByApplicationExpiryDate.getLessThan7Days())
		.sevenTo15Days(exceptionByApplicationExpiryDate.getSevenTo15Days())
		.fifteenTo30Days(exceptionByApplicationExpiryDate.getFifteenTo30Days())
		.greaterThan30Days(exceptionByApplicationExpiryDate.getGreaterThan30Days())
		.journey(exceptionManagementObject.getBusinessUnitOwner())
		.domainOwner(exceptionManagementObject.getDomainOwner())
		.productionOwner(exceptionManagementObject.getPlatformOwner())
		.riskOwner(exceptionManagementObject.getApplicationOwner())
		.build();
		return exceptionByApplication;
	}

	private ExceptionByApplication calculateExceptionByApplicationSubmissionDate(List<String> submissionDateList) 
	{
		long lessThan3Month = 0;
		long threeTo6Month = 0;
		long sixTo12Month = 0;
		long twelveTo24Month = 0;
		long greaterThan24Month = 0;
		for (String submissionDate : submissionDateList) {
			long diffInSubmissionDate = calculatedifferenceinDays(submissionDate);
			if (diffInSubmissionDate < 90) {
				lessThan3Month = lessThan3Month + 1;
				continue;
			}
			if (diffInSubmissionDate > 90 && diffInSubmissionDate < 180) {
				threeTo6Month = threeTo6Month + 1;
				continue;
			}
			if (diffInSubmissionDate > 180 && diffInSubmissionDate < 360) {
				sixTo12Month = sixTo12Month + 1;
				continue;
			}
			if (diffInSubmissionDate > 360 && diffInSubmissionDate < 720) {
				twelveTo24Month = twelveTo24Month + 1;
				continue;
			}
			if (diffInSubmissionDate > 720) {
				greaterThan24Month = greaterThan24Month + 1;
				continue;
			}
		}
		ExceptionByApplication exceptionByApplicationSubmissionDate = ExceptionByApplication.builder()
		.lessThan3Month(lessThan3Month).threeTo6Month(threeTo6Month).sixTo12Month(sixTo12Month)
		.twelveTo24Month(twelveTo24Month).greaterThan24Month(greaterThan24Month).build();
		return exceptionByApplicationSubmissionDate;
	}

	private ExceptionByApplication calculateExceptionByApplicationExpiryDate(List<String> exceptionExpiryDateList) 
	{
		long lessThan7Days = 0;
		long sevenTo15Days = 0;
		long fifteenTo30Days = 0;
		long greaterThan30Days = 0;
		for (String exceptionExpiryDate : exceptionExpiryDateList) {
			long diffInExpiryDate = calculatedifferenceinDays(exceptionExpiryDate);
			if (diffInExpiryDate < 7) {
				lessThan7Days = lessThan7Days + 1;
				continue;
			}
			if (diffInExpiryDate > 7 && diffInExpiryDate < 15) {
				sevenTo15Days = sevenTo15Days + 1;
				continue;
			}
			if (diffInExpiryDate > 15 && diffInExpiryDate < 30) {
				fifteenTo30Days = fifteenTo30Days + 1;
				continue;
			}
			if (diffInExpiryDate > 30) {
				greaterThan30Days = greaterThan30Days + 1;
				continue;
			}
		}
		ExceptionByApplication exceptionByApplicationExpiryDate = ExceptionByApplication.builder()
		.lessThan7Days(lessThan7Days).sevenTo15Days(sevenTo15Days).fifteenTo30Days(fifteenTo30Days)
		.greaterThan30Days(greaterThan30Days).build();
		return exceptionByApplicationExpiryDate;
	}

	private long calculatedifferenceinDays(String exceptionExpiryDate) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate passedDate = LocalDate.parse(exceptionExpiryDate, formatter);
		LocalDate currentDate = LocalDate.now();
		long diffInDays = ChronoUnit.DAYS.between(passedDate, currentDate);
		return diffInDays;
	}
	
	private ExceptionCountDashBoaard exceptionCountDashBoaardByExpiryDate(List<String> exceptionExpiryDateList) 
	{
		long openSince2Years=0;
		long openSince1Year=0;
		long openSince6Months=0;
		for (String exceptionExpiryDate : exceptionExpiryDateList) 
		{
			long diffInSubmissionDate = calculatedifferenceinDays(exceptionExpiryDate);
			if (diffInSubmissionDate > 180) {
				openSince6Months = openSince6Months + 1;
				continue;
			}
			if (diffInSubmissionDate > 365) {
				openSince1Year = openSince1Year + 1;
				continue;
			}
			if (diffInSubmissionDate > 730) {
				openSince2Years = openSince2Years + 1;
				continue;
			}
		}
		ExceptionCountDashBoaard exceptionCountDashBoaard = ExceptionCountDashBoaard.builder()
		.openSince6Months(openSince6Months).openSince1Year(openSince1Year).openSince2Years(openSince2Years)
		.build();
		return exceptionCountDashBoaard;
	}

	private ExceptionCountDashBoaard exceptionCountDashBoaardBySubmissionDate(List<String> submissionDateList) 
	{
		long dueinNext7Days=0;
		long dueinNext15Days=0;
		long dueinNext30Days=0;
		for (String exceptionExpiryDate : submissionDateList) 
		{
			long diffInSubmissionDate = calculatedifferenceinDays(exceptionExpiryDate);
			if (diffInSubmissionDate > 180) {
				dueinNext7Days = dueinNext7Days + 1;
				continue;
			}
			if (diffInSubmissionDate > 365) {
				dueinNext15Days = dueinNext15Days + 1;
				continue;
			}
			if (diffInSubmissionDate > 730) {
				dueinNext30Days = dueinNext30Days + 1;
				continue;
			}
		}
		ExceptionCountDashBoaard exceptionCountDashBoaard = ExceptionCountDashBoaard.builder()
		.dueinNext7Days(dueinNext7Days).dueinNext15Days(dueinNext15Days).dueinNext30Days(dueinNext30Days)
		.build();
		return exceptionCountDashBoaard;
	}
}
