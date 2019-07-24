package com.rcg.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rcg.com.dto.MedicalDetailsDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.YoungGustMedical_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class YoungGustMedicalDetailsController 
{
	@Autowired
	private YoungGustMedical_Service ms;
	
	@RequestMapping(method =RequestMethod.POST,value = "/medicaldetails/{cid}")
	public ResponseEntity<?> save(@RequestBody MedicalDetailsDto mdto,@PathVariable int cid) throws RitzkidsException
	{
		ms.save(mdto, cid);
		return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));
	}

	@RequestMapping(method =RequestMethod.PUT,value = "/medicaldetails/cid/{cid}/medicalid/{mid}")
	public ResponseEntity<?> update(@RequestBody MedicalDetailsDto mdto,@PathVariable int cid,@PathVariable int mid) throws RitzkidsException
	{
		ms.update(mdto, mid, cid);
		return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS));

	}
	
	
}
