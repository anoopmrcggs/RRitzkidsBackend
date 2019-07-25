package com.rcg.com.exceptions;

public class ConstraintsException extends Exception
{	
	
	private static final long serialVersionUID = 3594073818096320789L;
	
	private int code;
	
	public ConstraintsException(int code, String message) 
	{
		super(message);
		this.code = code;
	}

	public int getCode() 
	{
		return code;
	}

	public void setCode(int code) 
	{
		this.code = code;
	}

	
}
