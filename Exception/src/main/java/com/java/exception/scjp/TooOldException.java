package com.java.exception.scjp;

public class TooOldException extends Exception{
	private static final long serialVersionUID = 1L;
	public TooOldException(String message) {
		super(message);
	}
}
