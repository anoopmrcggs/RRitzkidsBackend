package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.ConsentForm;
import com.rcg.com.dto.ConsentFormDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.ConsentForm_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class ConsentFormController 
{
	@Autowired
	private ConsentForm_Service cs;
	
	//Save ConsentForm
	@RequestMapping(method = RequestMethod.POST,value="/language/{lid}/consentform")
	public ResponseEntity<?> save(@RequestBody ConsentFormDto cf,@PathVariable int lid) throws RitzkidsException
	{
		cs.saveConsentForm(cf, lid);
		return ResponseEntity.ok(new ResponseStatus<ConsentForm>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS));	
	}
	//Get All ConsentForm
	@RequestMapping("/consentform")
	public ResponseEntity<?> getAllConcernform()
	{
		return ResponseEntity.ok(new ResponseStatus<List<ConsentForm>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS,cs.getAllConsentForm()));	
	}
	//Get ConsentForm byID
	@RequestMapping("/language/{lid}/consentform")
	public ResponseEntity<?> getConcernform(@PathVariable int lid) throws RitzkidsException
	{
		
		return ResponseEntity.ok(new ResponseStatus<ConsentForm>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS,cs.getConsentFormById(lid)));	
	}
	//Update ConsentForm
	
	//Delete ConcernForm

}
