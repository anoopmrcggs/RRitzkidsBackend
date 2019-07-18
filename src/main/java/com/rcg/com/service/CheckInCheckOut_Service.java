package com.rcg.com.service;

import java.util.List;
import java.util.Optional;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface CheckInCheckOut_Service 
{
	public int saveCheckInCheckoutForm(CheckInCheckOutDto ceckincheckoutdto ) throws RitzkidsException;
	
	public List<CheckInCheckOut> getAllCheckInCheckoutForm() throws RitzkidsException;
	
	public Optional<CheckInCheckOut> getCheckInCheckoutForm(int cid) throws RitzkidsException;

}
