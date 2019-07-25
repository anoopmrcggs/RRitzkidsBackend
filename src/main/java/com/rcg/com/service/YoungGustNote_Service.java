package com.rcg.com.service;


import java.util.List;

import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.dto.YoungGustNotesDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface YoungGustNote_Service 
{
	public void saveYoungGustNote(YoungGustNotesDto youngGustNotesDto,int cid) throws RitzkidsException;
	public List<YoungGustNotes> getYoungGustNotes(int cid) throws RitzkidsException; 
	public void updateYoungGustNote(YoungGustNotesDto youngGustNotesDto,int cid,int nid) throws RitzkidsException;
	public void deleteYoungGustNote(int nid) throws RitzkidsException;

}
