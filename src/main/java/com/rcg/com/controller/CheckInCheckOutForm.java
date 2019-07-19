package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.CheckInCheckOut_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class CheckInCheckOutForm 
{
	@Autowired
	private CheckInCheckOut_Service cs;
	
	@RequestMapping(method = RequestMethod.POST,value="/checkincheckoutform")
	public ResponseEntity<?> save(@RequestBody CheckInCheckOutDto cdto) throws RitzkidsException
	{
		cs.saveCheckInCheckoutForm(cdto);
		return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping("/checkincheckoutform")
	public ResponseEntity<?>getAllForm() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<CheckInCheckOut>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,cs.getAllCheckInCheckoutForm()));
	}
	

	
	
}
