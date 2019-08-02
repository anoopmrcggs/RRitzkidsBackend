package com.rcg.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Employee;
import com.rcg.com.dao.Login;
import com.rcg.com.dto.LoginDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.EmployeeRepository;
import com.rcg.com.repository.LoginRepository;
import com.rcg.com.util.MDEncryption;
import com.rcg.com.util.RitzConstants;

@Service
public class Login_ServiceImpl implements Login_Service 
{
	@Autowired
	private LoginRepository lr;
	
	@Autowired
	private EmployeeRepository er;
	
	@Override
	public Employee loginValidate(LoginDto ldto) throws RitzkidsException 
	{

		Optional<Login> loginO= lr.getLoginByusername(ldto.getUsername());
		if(!loginO.isPresent())
		{
			throw new RitzkidsException("User not found", RitzConstants.ERROR_CODE);
		}
		else
		{
			
			if((MDEncryption.getMd5(ldto.getPassword().toString())).equals(loginO.get().getPassword()))
			{
				Optional<Employee> emp=er.findById(loginO.get().getEmployee().getEmployeeId());
				if(!emp.isPresent())
				{
					throw new RitzkidsException("No employee where found in this ID", RitzConstants.ERROR_CODE);

				}
				else
				{					
					if(er.findById(emp.get().getEmployeeId()).get().getIsactive())
					{
						return er.findById(emp.get().getEmployeeId()).get();
					}
					else
					{
						throw new RitzkidsException("Not an active employee",RitzConstants.ERROR_CODE);
					}
				}
			}
			else
			{
				throw new RitzkidsException("Invalid password", RitzConstants.ERROR_CODE);

			}
		}
	}

}
