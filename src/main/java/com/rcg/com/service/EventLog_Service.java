package com.rcg.com.service;


import java.util.List;

import com.rcg.com.dao.EventLog;
import com.rcg.com.dto.EventLogDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface EventLog_Service 
{
	public void saveEventLog(EventLogDto edto,int cid) throws RitzkidsException;
	public List<EventLog> getEventLog(int cid) throws RitzkidsException; 
	public void updateEventLog(EventLogDto edto,int cid,int nid) throws RitzkidsException;

}
