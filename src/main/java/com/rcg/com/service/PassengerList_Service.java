package com.rcg.com.service;

import java.security.acl.Permission;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dto.PassengerListDto;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.dto.YoungGustDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.GuardianRepository;
import com.rcg.com.repository.YoungGustRepository;

public interface PassengerList_Service 
{
	public String savePassenger(PassengerListWrapper p)throws RitzkidsException;
	
	public List<Guardian> getAllGuardian()throws RitzkidsException;
	
	public Guardian getGuardian(int gid)throws RitzkidsException;


}
