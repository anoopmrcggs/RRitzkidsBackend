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

import com.rcg.com.dao.EventLog;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.EventLogDto;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.EventLog_Service;
import com.rcg.com.service.YoungGustNote_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class EventLogController 
{
	@Autowired
	private EventLog_Service es;
	
	@RequestMapping(method=RequestMethod.POST,value="/eventlog/{cid}")
	public ResponseEntity<?> save(@Valid @RequestBody EventLogDto edto,@PathVariable int cid) throws RitzkidsException
	{
		es.saveEventLog(edto, cid);
		return ResponseEntity.ok(new ResponseStatus<EventLog>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));

	}
	
	@RequestMapping("/eventlog/{cid}")
	public ResponseEntity<?> geteventlog(@PathVariable int cid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<EventLog>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,es.getEventLog(cid)));
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/eventlog/cid/{cid}/eventid/{elid}")
	public ResponseEntity<?> update(@RequestBody EventLogDto ydto,@PathVariable int cid,@PathVariable int elid) throws RitzkidsException
	{
		es.updateEventLog(ydto,cid,elid);
		return ResponseEntity.ok(new ResponseStatus<EventLog>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));

	}

}
