package com.rcg.com.util;

public class ResponseStatus<T> 
{
	private int code;
	private String status;
	private String message;
	private T data;
	
	
	
	public ResponseStatus(int code, String status, String message, T data) 
	{
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public ResponseStatus(int code, String status, String message) 
	{
		super();
		this.code = code;
		this.status = status;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}	

}
