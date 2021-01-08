package com.jio.javainterviewpoint.exception;

public class TooYoungException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public TooYoungException(String message) {
		super(message);
	}
}
