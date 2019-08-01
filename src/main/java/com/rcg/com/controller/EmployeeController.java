package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Employee;
import com.rcg.com.dto.EmployeeDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Employee_ServiceImpl;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	@Autowired
	private Employee_ServiceImpl es;
	
	//Save Employee
	@RequestMapping(method = RequestMethod.POST,value = "/employee")
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto edto) throws RitzkidsException
	{
		es.SaveEmployee(edto);
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	//get All Employee
	@RequestMapping("/employee")
	public ResponseEntity<?> getAllEmployee() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<Employee>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,es.getAllEmployee()));
	}
	
	//Get Single Employee
	@RequestMapping("/employee/{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable int eid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS, es.getEmployee(eid)));
	}
	
	//Employee Role Assigning
	@RequestMapping(method = RequestMethod.PUT,value = "/employee/{eid}/role/{rid}")
	public ResponseEntity<?> assignrole(@PathVariable int eid,@PathVariable int rid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	//Employee update
	@RequestMapping(method = RequestMethod.PUT,value = "/employee/pass/update/{eid}")
	public ResponseEntity<?> update(@PathVariable int eid,@RequestBody EmployeeDto edto) throws RitzkidsException
	{
		es.updateEmployee(edto, eid);
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	
	//Employee Password Change
	@RequestMapping(method = RequestMethod.PUT,value = "/employee/pass/change/{eid}")
	public ResponseEntity<?> changePassword(@PathVariable int eid,@RequestBody EmployeeDto edto) throws RitzkidsException
	{
		es.passwordChange(edto, eid);
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	//Employee Password Reset
	@RequestMapping(method = RequestMethod.PUT,value = "/employee/pass/reset/{eid}")
	public ResponseEntity<?> resetPassword(@PathVariable int eid,@RequestBody EmployeeDto edto) throws RitzkidsException
	{
		es.passwordReset(edto, eid);
		return ResponseEntity.ok(new ResponseStatus<Employee>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	
}
