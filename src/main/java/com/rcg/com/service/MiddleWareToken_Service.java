package com.rcg.com.service;

import com.rcg.com.exceptions.RitzkidsException;

public interface MiddleWareToken_Service 
{
	//save token
	public String saveToken(String token, int eid) throws RitzkidsException;
	
	//get Token
	//public String getToken(int eid) throws RitzkidsException;
}
