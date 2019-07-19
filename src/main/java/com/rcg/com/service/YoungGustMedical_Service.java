package com.rcg.com.service;

import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface YoungGustMedical_Service 
{
	public void save(MedicalDetailsDto mdto,int cid)throws RitzkidsException;
	
	public void update(MedicalDetailsDto mdto,int mid,int cid) throws RitzkidsException;
	
	
}
