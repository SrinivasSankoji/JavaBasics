package com.jio.ngo.exception.dto;

public class NGOException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public NGOException() 
	{
		super();
	}
	
	public NGOException(final String message) 
	{
		super(message);
	}

}
