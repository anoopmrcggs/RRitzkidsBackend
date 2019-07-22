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
import com.rcg.com.dao.ConsentFormTemplate;
import com.rcg.com.dto.ConsentFormDto;
import com.rcg.com.dto.ConsentformTemplateWrapper;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.ConsentFormTemplate_Service;
import com.rcg.com.service.ConsentForm_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class ConsentFormTemplateController 
{
	@Autowired
	private ConsentFormTemplate_Service cs;
	
	//Save ConsentForm
	@RequestMapping(method = RequestMethod.POST,value="/language/{lid}/consentformtemplate")
	public ResponseEntity<?> save(@RequestBody ConsentformTemplateWrapper cf,@PathVariable int lid) throws RitzkidsException
	{
		cs.saveConsentForm(cf, lid);
		return ResponseEntity.ok(new ResponseStatus<ConsentForm>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS));	
	}
	//Get All ConsentForm
	@RequestMapping("/consentformtemplate")
	public ResponseEntity<?> getAllConcernform()
	{
		return ResponseEntity.ok(new ResponseStatus<List<ConsentFormTemplate>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS,cs.getAllConsentForm()));	
	}
	//Get ConsentForm byID
	@RequestMapping("/language/{lid}/consentformtemplate")
	public ResponseEntity<?> getConcernform(@PathVariable int lid) throws RitzkidsException
	{
		
		return ResponseEntity.ok(new ResponseStatus<List<ConsentFormTemplate>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS,cs.getAllConsentForm()));	
	}
	//Update ConsentForm
	
	//Delete ConcernForm

}
