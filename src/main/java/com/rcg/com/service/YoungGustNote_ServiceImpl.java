package com.rcg.com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.CheckInCheckOutRepository;
import com.rcg.com.repository.YoungGustNotesRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class YoungGustNote_ServiceImpl implements YoungGustNote_Service 
{
	@Autowired
	private YoungGustNotesRepository ygr;
	
	@Autowired
	private CheckInCheckOutRepository ccr;
	
	@Override
	public void saveYoungGustNote(YoungGustNotesDto youngGustNotesDto,int cid) throws RitzkidsException 
	{
		if(!ccr.findById(cid).isPresent())
		{
			throw new RitzkidsException("CheckinCheckout ID not valid",RitzConstants.ERROR_CODE);
		}
		else
		{
			YoungGustNotes yg=youngGoustNoteModelMapper(youngGustNotesDto);
			yg.setCheckinCheckout(new CheckInCheckOut(cid));
			ygr.save(yg);
		}

	}
	
	public void updateYoungGustNote(YoungGustNotesDto youngGustNotesDto,int cid,int nid) throws RitzkidsException
	{
		if(!ygr.findById(nid).isPresent())
		{
			throw new RitzkidsException("YoungGustNote ID not valid",RitzConstants.ERROR_CODE);
		}
		else
		{
			YoungGustNotes yg=youngGoustNoteModelMapper(youngGustNotesDto);
			yg.setCheckinCheckout(new CheckInCheckOut(cid));
			yg.setYoungGustNotesId(nid);
			ygr.save(yg);
		}
		
	}
	
	
	public YoungGustNotes youngGoustNoteModelMapper(YoungGustNotesDto ydto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(ydto, YoungGustNotes.class);
	}

}