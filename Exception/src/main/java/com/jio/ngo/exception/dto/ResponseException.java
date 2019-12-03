package com.jio.ngo.exception.dto;

import lombok.Data;

@Data
public class ResponseException 
{
	private String errorMessage;
	private String path;
	private Integer status;
	private String timestamp;
	

	
}
