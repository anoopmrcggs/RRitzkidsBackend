package com.rcg.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.EventLog;
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.exceptions.RitzkidsException;

public interface EventLogRepository extends CrudRepository<EventLog, Integer> 
{
	public List<EventLog>  getYoungGustNotesBycheckinCheckoutCheckinCheckoutId(int cid)throws RitzkidsException;

}
