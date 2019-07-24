package com.rcg.com.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dto.AuthorizedRelationDto;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.CheckInCheckOut_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class CheckInCheckOutFormController 
{
	@Autowired
	private CheckInCheckOut_Service cs;
	
	@RequestMapping(method = RequestMethod.POST,value="/checkincheckoutform")
	public ResponseEntity<?> save(@RequestBody CheckInCheckOutDto cdto) throws RitzkidsException
	{
		//int cid=cs.saveCheckInCheckoutForm(cdto);
		return ResponseEntity.ok(new ResponseStatus<Integer>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS, cs.saveCheckInCheckoutForm(cdto)));
		//return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping("/checkincheckoutform")
	public ResponseEntity<?>getAllForm() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<CheckInCheckOut>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,cs.getAllCheckInCheckoutForm()));
	}
	
	@RequestMapping("/checkincheckoutform/{cid}")
	public ResponseEntity<?>getForm(@PathVariable int cid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,cs.getCheckInCheckoutForm(cid)));
	}
	
	@RequestMapping("/checkincheckoutform/{cid}/ar/{aid}/status/{st}")
	public ResponseEntity<?>updateForm(@PathVariable boolean st,@PathVariable int cid,@PathVariable int aid) throws RitzkidsException
	{
		cs.updateCheckinCheckout(st, cid, aid);
		return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
}
