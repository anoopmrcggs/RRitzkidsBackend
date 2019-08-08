package com.rcg.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dto.CheckInCheckOutDto;
import com.rcg.com.dto.CheckInCheckOutStatsUpdationDto;
import com.rcg.com.dto.YoungGustCheckinStatusDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.CheckInCheckOut_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class CheckInCheckOutForm_Controller 
{
	@Autowired
	private CheckInCheckOut_Service cs;
	
	@RequestMapping(method = RequestMethod.POST,value="/checkincheckoutform")
	public ResponseEntity<?> save(@Valid @RequestBody CheckInCheckOutDto cdto) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Integer>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS, cs.saveCheckInCheckoutForm(cdto)));
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

	
	@RequestMapping(method=RequestMethod.POST , value = "/checkincheckoutform/status")
	public ResponseEntity<?>updateStatus(@RequestBody CheckInCheckOutStatsUpdationDto cdto) throws RitzkidsException
	{
		cs.updateCheckinCheckout(cdto);
		return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/checkincheckoutform/{cid}")
	public ResponseEntity<?> updateCheckinChekoutForm(@RequestBody CheckInCheckOutDto cdto,@PathVariable int cid) throws RitzkidsException
	{
		cs.updateCheckinCheckout(cdto, cid);
		return ResponseEntity.ok(new ResponseStatus<CheckInCheckOut>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping("/youngguestcheckinstatus/{fid}")
	public ResponseEntity<?> youngGuestCheckinStatus(@PathVariable int fid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<YoungGustCheckinStatusDto>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,cs.getCheckinCheckoutStatus(fid)));
	}
	
}
