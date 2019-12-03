package com.jio.ngo.exception.dto;

import java.io.Serializable;
import java.util.List;

import com.jio.ngo.exception.model.ExceptionManagement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder=true)
public class ExceptionManagementResponse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private List<ExceptionManagement> changeInOwnerList;
	private List<ExceptionManagement> changeInDueList;
	private List<ExceptionManagement> newRecordList;

}
