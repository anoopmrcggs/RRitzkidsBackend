package com.rcg.com.exceptions;

public class RitzkidsException extends Exception 
{
	
	private static final long serialVersionUID = -7621538005853247535L;
	
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
