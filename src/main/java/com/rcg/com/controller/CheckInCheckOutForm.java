package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.CheckInCheckOut_Service;

@RestController
@RequestMapping("/ritzkids")
public class CheckInCheckOutForm 
{
	@Autowired
	private CheckInCheckOut_Service cs;
	
	@RequestMapping(method = RequestMethod.POST,value="/checkincheckoutform")
	public String save(@RequestBody CheckInCheckOutDto cdto) throws RitzkidsException
	{
		cs.saveCheckInCheckoutForm(cdto);
		return "successs";
	}
	
	@RequestMapping("/checkincheckoutform")
	public List<CheckInCheckOut> getAllForm() throws RitzkidsException
	{
		return cs.getAllCheckInCheckoutForm();
	}
	

	
	
}
