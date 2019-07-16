package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Employee;
import com.rcg.com.dto.EmployeeDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface Employee_Service 
{
	public int SaveEmployee(EmployeeDto edto) throws RitzkidsException;
	
	public List<Employee> getAllEmployee() throws RitzkidsException;
	
	public Employee getEmployee(int eid) throws RitzkidsException;

	public int updateEmployee(int eid,EmployeeDto employee) throws RitzkidsException;
	
	public String roleAssign(int empid,int rid)throws RitzkidsException;
	
	public String deleteEmployee(int eid) throws RitzkidsException;
	
	
}
