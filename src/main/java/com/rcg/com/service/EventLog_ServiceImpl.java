package com.rcg.com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.EventLog;
import com.rcg.com.dto.EventLogDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.CheckInCheckOutRepository;
import com.rcg.com.repository.EventLogRepository;
import com.rcg.com.util.RitzConstants;


@Service
public class EventLog_ServiceImpl implements EventLog_Service
{

	@Autowired
	private EventLogRepository er;
	
	@Autowired
	private CheckInCheckOutRepository ccr;
	
	@Override
	public void saveEventLog(EventLogDto edto, int cid) throws RitzkidsException 
	{
		if(!ccr.findById(cid).isPresent())
		{
			throw new RitzkidsException("CheckinCheckout ID not valid",RitzConstants.ERROR_CODE);
		}
		else
		{
			EventLog el=eventLogModelMapper(edto);
			el.setCheckinCheckout(new CheckInCheckOut(cid));
			el.setCreated(new Date());
			el.setUpdated(new Date());
			er.save(el);
		}
	}

	@Override
	public List<EventLog> getEventLog(int cid) throws RitzkidsException 
	{
		if(!ccr.findById(cid).isPresent())
		{
			throw new RitzkidsException("CheckinCheckout ID is not valid",RitzConstants.ERROR_CODE);
		}
		else
		{
			List<EventLog> el=new ArrayList<EventLog>();
			er.getYoungGustNotesBycheckinCheckoutCheckinCheckoutId(cid).forEach(el::add);
			return el;
		}
	}

	@Override
	public void updateEventLog(EventLogDto edto, int cid, int elid) throws RitzkidsException 
	{
		if(!er.findById(elid).isPresent())
		{
			throw new RitzkidsException("Eventlog ID not valid",RitzConstants.ERROR_CODE);
		}
		else
		{
			EventLog el=eventLogModelMapper(edto);
			el.setCheckinCheckout(new CheckInCheckOut(cid));
			el.setUpdated(new Date());
			el.setEventLogId(elid);
			er.save(el);
		}
		
	}

	public EventLog eventLogModelMapper(EventLogDto edto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(edto, EventLog.class);
	}
}
