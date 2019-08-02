package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.ConsentFormTemplate;
import com.rcg.com.dto.ConsentformTemplateWrapper;
import com.rcg.com.dto.SaveConsentFormDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.ConsentFormTemplate_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class ConsentFormTemplate_Controller 
{
	@Autowired
	private ConsentFormTemplate_Service cs;
	
	//Save ConsentForm
	@RequestMapping(method = RequestMethod.POST,value="/language/{lid}/consentformtemplate")
	public ResponseEntity<?> save(@RequestBody ConsentformTemplateWrapper cf,@PathVariable int lid) throws RitzkidsException
	{
		//cf.getConsentFomTemplateDto().forEach((a)->System.out.println("Data : Head - "+a.getHead()+" - Boady - "+a.getBoady()+" - Item - "+a.getItem()));
		cs.saveConsentForm(cf, lid);
		return ResponseEntity.ok(new ResponseStatus<ConsentFormTemplate>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS));	
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
		
		return ResponseEntity.ok(new ResponseStatus<List<ConsentFormTemplate>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS,cs.getConsentFormById(lid)));	
	}
	
	//Generate PDF from Consent form
	
	@RequestMapping(method = RequestMethod.POST,value="/saveconsentfom")
	public ResponseEntity<?> generatePDF(@RequestBody SaveConsentFormDto cfdto) throws RitzkidsException
	{
		System.out.println("Completed Consent Form");
		cs.generatePDF(cfdto);
		return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK, RitzConstants.SUCCESS));	
	}
	
	
	
	//Update ConsentForm
	
	//Delete ConcernForm

}
