package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Language;
import com.rcg.com.dto.LanguageDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Language_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class LanguageController 
{
	@Autowired
	private Language_Service ls;
	//save Language
	
	@RequestMapping(method = RequestMethod.POST,value="/language")
	public ResponseEntity<?> save(@RequestBody LanguageDto ldto)
	{
		ls.saveLanguage(ldto);
		return ResponseEntity.ok(new ResponseStatus<Language>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
	
	//Get All Language
	@RequestMapping("/language")
	public ResponseEntity<?> getAllLanguage()
	{
		return ResponseEntity.ok(new ResponseStatus<List<Language>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS,ls.getAllLanguage()));
	}
	
	//Get Language By Id
	@RequestMapping("/language/{lid}")
	public ResponseEntity<?> getLanguage(@PathVariable int lid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Language>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS,ls.getLanguageById(lid)));
	}
	
	//Update Language
	@RequestMapping(method = RequestMethod.PUT,value="/language/{lid}")
	public ResponseEntity<?> updateLanguage(@RequestBody LanguageDto ldto,@PathVariable int lid) throws RitzkidsException,ConstraintsException
	{
		ls.updateLanguage(ldto, lid);
		return ResponseEntity.ok(new ResponseStatus<Language>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
	
	//Delete Language
	@RequestMapping(method = RequestMethod.DELETE,value="/language/{lid}")
	public ResponseEntity<?> deleteLanguage(@PathVariable int lid) throws RitzkidsException
	{
		ls.deleteLanguage(lid);
		return ResponseEntity.ok(new ResponseStatus<Language>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
}
