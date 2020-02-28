package com.jio.ngo.exception.dto;

public class DatabaseException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public DatabaseException() 
	{
		super();
	}
	
	public DatabaseException(final String message) 
	{
		super(message);
	}

}
