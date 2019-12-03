package com.jio.ngo.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorHeader implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String serviceUrl;
	private String message;

}
