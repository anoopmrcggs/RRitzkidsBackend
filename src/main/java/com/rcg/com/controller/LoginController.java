package com.rcg.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Employee;
import com.rcg.com.dto.LoginDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Login_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class LoginController 
{
	@Autowired
	private Login_Service ls;
	
	@RequestMapping(method = RequestMethod.POST,value="/login")
	public ResponseEntity<?> validateLogin(@RequestBody LoginDto ldto) throws RitzkidsException
	{
		System.out.println("Name : "+ldto.getUsername());
		System.out.println("Login Controller");
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,ls.loginValidate(ldto)));
	}
}
