package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dto.PassengerListDto;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.PassengerList_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class PassengerListController
{
	@Autowired
	private PassengerList_Service ps;
	
	
	   // Saving All Passengers  
	  @RequestMapping(method = RequestMethod.POST,value = "/passengerlist") 
	  public  ResponseEntity<?> savePassenger(@RequestBody PassengerListWrapper pl) throws RitzkidsException 
	  {
		  ps.savePassenger(pl);
		  return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS)); 
	  }
	  
	  //getting All Guardians
	  @RequestMapping("/guardianlist") 
	  public  ResponseEntity<?> getAllGuardian() throws RitzkidsException 
	  {
		  return ResponseEntity.ok(new ResponseStatus<List<Guardian>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getAllGuardian())); 
	  }
	  
	  //getting Single Guardian
	  @RequestMapping("/guardianlist/{gid}") 
	  public  ResponseEntity<?> getGuardian(@PathVariable int gid) throws RitzkidsException 
	  {
		  return ResponseEntity.ok(new ResponseStatus<Guardian>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getGuardian(gid))); 
	  }
	 
	/*
	 * @RequestMapping(method = RequestMethod.POST,value = "/passengerlist") public
	 * ResponseEntity<?> savePassenger(@RequestBody PassengerListDto pl) {
	 * System.out.println("Dta : "+pl.getFirstname()+" -- "+pl.getPassengertype()
	 * +" -- "+pl.getBirthdate()+" -- "+pl.isIsactive()); //ps.savePassenger(pl);
	 * return ResponseEntity.ok(new
	 * ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.
	 * SUCCESS)); }
	 */
	
	
}
