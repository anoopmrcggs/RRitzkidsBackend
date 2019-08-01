package com.rcg.com.controller;

import java.util.List;

import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Guardian;
import com.rcg.com.dto.DataDto;
import com.rcg.com.dto.GuestListDto;
import com.rcg.com.dto.PassengerListDto;
import com.rcg.com.dto.PassengerListWrapper;
import com.rcg.com.dto.ResponseWrapperDto;
import com.rcg.com.dto.SearchDataDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.GuestList_Service;
import com.rcg.com.service.PassengerList_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class PassengerListController
{
	@Autowired
	private GuestList_Service gs;
	
	@Autowired
	private PassengerList_Service ps;
	
	
	  // Saving All Passengers
	  
	  @RequestMapping(method = RequestMethod.POST,value = "/passengerlist") 
	  public ResponseEntity<?> savePassenger(@RequestBody PassengerListWrapper pl) throws RitzkidsException 
	  { 
		  return ResponseEntity.ok(new  ResponseStatus<List<Guardian>>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getAllGuardianByBookingId(ps.savePassenger(pl)))); 
	  }
	 
	  @RequestMapping(method = RequestMethod.POST,value="/guardianlist") 
	  public ResponseEntity<?> getAllGuardians(@RequestBody SearchDataDto sdto) throws RitzkidsException 
	  {
		  return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getAllGuardian())); 
	  }
	  
	  
	  //Search All Guardians From Middle-ware
	  @RequestMapping(method = RequestMethod.POST,value="/guestlist") 
	  public  ResponseWrapperDto getAllGuardianFromMiddleWare(@RequestBody SearchDataDto sdto) throws RitzkidsException 
	  {
		  return gs.getGuest(sdto);
		 //return ResponseEntity.ok(new ResponseStatus>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,gs.getGuest(sdto))); 
	  }
	  
	  //Search All Guardians From DB
	  @RequestMapping(method = RequestMethod.GET,value="/guestlist/{bid}") 
	  public  ResponseEntity<?>  getAllGuardianByBookingID(@PathVariable long bid) throws RitzkidsException 
	  {
		 return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getAllGuardianByBookingId(bid))); 
	  }
	  
	
	  //getting Single Guardian
	  @RequestMapping("/guardianlist/{gid}") public ResponseEntity<?>
	  getGuardian(@PathVariable int gid) throws RitzkidsException 
	  { 
		  return ResponseEntity.ok(new ResponseStatus<Guardian>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.SUCCESS,ps.getGuardian(gid))); 
	  }
	 
	 
	/*
	 * @RequestMapping(method = RequestMethod.POST,value = "/passengerlist") public
	 * ResponseEntity<?> savePassenger(@RequestBody PassengerListDto pl) {
	 * ps.savePassenger(pl); return ResponseEntity.ok(new
	 * ResponseStatus<>(RitzConstants.SUCCESS_CODE,RitzConstants.OK,RitzConstants.
	 * SUCCESS)); }
	 */
	 
	
	
}
