package com.rcg.com.exceptions;

public class RitzkidsException extends Exception 
{
	private int ex_code;
	
	public RitzkidsException(String message,int ex_code)
	{
		super(message);
		this.ex_code=ex_code;
	}

	public int getEx_code() 
	{
		return ex_code;
	}

	public void setEx_code(int ex_code) 
	{
		this.ex_code = ex_code;
	}
	
	
}
