package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.exceptions.RitzkidsException;

public interface PassengerList_Service 
{
	public String savePassenger(PassengerListWrapper p)throws RitzkidsException;
	
	public List<Guardian> getAllGuardian()throws RitzkidsException;
	
	public Guardian getGuardian(int gid)throws RitzkidsException;


}
