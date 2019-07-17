package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Employee;
import com.rcg.com.dao.Role;
import com.rcg.com.dto.EmployeeDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.EmployeeRepository;
import com.rcg.com.repository.RoleRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class Employee_ServiceImpl implements Employee_Service 
{

	@Autowired
	private EmployeeRepository er; 
	
	@Autowired
	private RoleRepository rr; 
	
	private int createdby=100;
	private int updatedby=100;
	private Calendar calender=Calendar.getInstance();
	
	
	@Override
	public int SaveEmployee(EmployeeDto edto) throws RitzkidsException 
	{
		Employee emp=employeeMapper(edto);
		emp.setCreated(calender.getTime());
		emp.setUpdated(calender.getTime());
		emp.setCreatedby(createdby);
		emp.setUpdatedby(updatedby);
		er.save(emp);
		return emp.getEmployee_id();
	}

	@Override
	public List<Employee> getAllEmployee() throws RitzkidsException 
	{
		List<Employee> emp=new ArrayList<Employee>();
		er.findAll().forEach(emp::add);
		return emp;
	}
	
	@Override
	public Employee getEmployee(int eid) throws RitzkidsException 
	{
		Optional<Employee> emp=er.findById(eid);
		if(!emp.isPresent())
		{
			throw new RitzkidsException("Employee not found with given ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			return emp.get();
		}
	
	}

	@Deprecated
	@Override
	public int updateEmployee(int eid, EmployeeDto employee) throws RitzkidsException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Deprecated
	@Override
	public String deleteEmployee(int eid) throws RitzkidsException {
		// TODO Auto-generated method stub
		return null;
	}

	//Employee Role Assigning
	public String roleAssign(int eid,int rid) throws RitzkidsException
	{
		if(er.findById(eid).isPresent())
		{
			if(rr.findById(rid).isPresent())
			{
				Employee emp=er.findById(eid).get();
				emp.setRole(new Role(rid));
				er.save(emp);
				
			}
			else
			{
				throw new RitzkidsException("No role were found in this ID",RitzConstants.ERROR_CODE);
			}
		}
		else
		{
			throw new RitzkidsException("No Employee were found in this ID", RitzConstants.ERROR_CODE);
		}
		return "Success";
	}
	
	private Employee employeeMapper(EmployeeDto employee)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(employee,Employee.class);
	}

	

}
