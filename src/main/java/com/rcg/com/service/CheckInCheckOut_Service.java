package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface CheckInCheckOut_Service 
{
	public int saveCheckInCheckoutForm(CheckInCheckOutDto ceckincheckoutdto ) throws RitzkidsException;
	
	public List<CheckInCheckOut> getAllCheckInCheckoutForm() throws RitzkidsException;
	
	public CheckInCheckOut getCheckInCheckoutForm(int cid) throws RitzkidsException;
	
	public int updateCheckinCheckout(CheckInCheckOutDto cdto,int cid) throws RitzkidsException;

	public int updateCheckinCheckoutStatus(boolean status,int cid,int arid) throws RitzkidsException;

}
