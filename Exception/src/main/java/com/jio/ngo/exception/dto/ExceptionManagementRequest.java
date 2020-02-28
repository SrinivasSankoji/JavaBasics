package com.jio.ngo.exception.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ExceptionManagementRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	String userName;
	String jobName;
	List<Object[]> jsonData;

}
