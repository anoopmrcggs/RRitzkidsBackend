package com.rcg.com.service;


import com.rcg.com.dao.Employee;
import com.rcg.com.dto.LoginDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface Login_Service 
{
	public Employee loginValidate(LoginDto ldto) throws RitzkidsException;
}
