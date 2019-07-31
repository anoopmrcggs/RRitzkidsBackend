package com.rcg.com.dto;

import java.util.List;

public class ResponseWrapperDto 
{
	 int code;
	 String message;
	 List<DataDto> data;
	 String status;
	 
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<DataDto> getData() {
		return data;
	}
	public void setData(List<DataDto> data) {
		this.data = data;
	}
	
	 
	 
}
