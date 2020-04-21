package com.jio.ngo.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class NGOError implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ErrorHeader responseHeader = new ErrorHeader();
	private Object responsePayload;
	
}
