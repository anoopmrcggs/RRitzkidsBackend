package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Employee;
import com.rcg.com.dao.Login;
import com.rcg.com.dao.Role;
import com.rcg.com.dto.EmployeeDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.EmployeeRepository;
import com.rcg.com.repository.LoginRepository;
import com.rcg.com.repository.RoleRepository;
import com.rcg.com.util.MDEncryption;
import com.rcg.com.util.RitzConstants;

@Service
public class Employee_ServiceImpl implements Employee_Service 
{

	@Autowired
	private EmployeeRepository er; 
	
	@Autowired
	private RoleRepository rr; 
	
	@Autowired
	private LoginRepository lr;
	
	private int createdby=100;
	private int updatedby=100;
	private Calendar calender=Calendar.getInstance();
	
	
	@Override
	public int SaveEmployee(EmployeeDto edto) throws RitzkidsException 
	{
		Employee emp=employeeMapper(edto);
		emp.setCreated(new Date());
		emp.setUpdated(new Date());
		emp.setIsactive(true);
		emp.setCreatedby(edto.getCreatedby());
		emp.setUpdatedby(edto.getUpdatedby());
		er.save(emp);
		
		// Saving login Credential
		
		Login lg=new Login();
		lg.setUsername(edto.getUsername());
		lg.setPassword(MDEncryption.getMd5(edto.getPassword()));
		lg.setEmployee(emp);
		lg.setCretedBy(edto.getCreatedby());
		lg.setUpdatedBy(edto.getUpdatedby());
		lg.setUpdated(new Date());
		lr.save(lg);
		
		return emp.getEmployeeId();
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
	
//Update Employee
	
	@Override
	public String updateEmployee(EmployeeDto edto,int eid) throws RitzkidsException 
	{
		if(edto.getFirstName()!=null)
		{
			if(edto.getLastName()!=null)
			{
				if(edto.getIsactive()!=null)
				{
					Optional<Employee> empO=er.findById(eid);
					if(!empO.isPresent())
					{
						throw new RitzkidsException("No Employe were found in This ID", RitzConstants.ERROR_CODE);
					}
					else
					{
						Employee employee=empO.get();
						employee.setFirstName(edto.getFirstName());
						employee.setLastName(edto.getLastName());
						employee.setIsactive(edto.getIsactive());
						employee.setUpdatedby(edto.getUpdatedby());
						employee.setEmployeeId(eid);
						employee.setUpdated(new Date());
						employee.setCreated(new Date());
						er.save(employee);
					}
					
				}
				else
				{
					throw new RitzkidsException("Null employee status", RitzConstants.ERROR_CODE);
				}
			}
			else
			{
				throw new RitzkidsException("Last name is null", RitzConstants.ERROR_CODE);

			}
		}
		else
		{
			throw new RitzkidsException("First name is null", RitzConstants.ERROR_CODE);
		}
		return "Success";
	}
	
//Password Resetting

	@Override
	public String passwordReset(EmployeeDto edto, int eid) throws RitzkidsException 
	{
		Optional<Login> loginO=lr.getLoginByemployeeEmployeeId(eid);
		if(!loginO.isPresent())
		{
			throw new RitzkidsException("Invalid Employee ID : "+eid, RitzConstants.ERROR_CODE);
		}
		else
		{
			if(edto.getPassword()!=null)
			{
				Login login=loginO.get();
				login.setPassword(MDEncryption.getMd5(edto.getPassword()));
				login.setUpdated(new Date());
				
				
				lr.save(login);
			}
			else
			{
				throw new RitzkidsException("Blank password",RitzConstants.ERROR_CODE );
			}
		}
		return "Success";
	}


	@Override
	public String passwordChange(EmployeeDto edto, int eid) throws RitzkidsException 
	{
		Optional<Login> loginO=lr.getLoginByemployeeEmployeeId(eid);
		if(!loginO.isPresent())
		{
			throw new RitzkidsException("Invalid Employee ID : "+eid, RitzConstants.ERROR_CODE);
		}
		else
		{
			if(edto.getPassword()!=null && edto.getNewPassword()!=null) 
			{
				Login login=loginO.get();
				
				if(MDEncryption.getMd5(edto.getPassword()).equals(login.getPassword()))
				{
					login.setPassword(MDEncryption.getMd5(edto.getNewPassword()));
					login.setUpdated(new Date());
					lr.save(login);
				}
				else
				{
					throw new RitzkidsException("Old password is wrong", RitzConstants.ERROR_CODE);
	
				}
			}
			else
			{
				throw new RitzkidsException("Password and New password should not be null", RitzConstants.ERROR_CODE);
			}
		}
		return "Success";
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
