package com.rcg.com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rcg.com.dao.YoungGustNotes;
import com.rcg.com.exceptions.RitzkidsException;

public interface YoungGustNotesRepository extends CrudRepository<YoungGustNotes, Integer> 
{
	public List<YoungGustNotes>  getYoungGustNotesBycheckinCheckoutCheckinCheckoutId(int cid)throws RitzkidsException;

}
