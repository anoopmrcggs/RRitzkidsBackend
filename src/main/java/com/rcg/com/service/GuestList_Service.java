package com.rcg.com.service;


import com.rcg.com.dto.ResponseWrapperDto;
import com.rcg.com.dto.SearchDataDto;
import com.rcg.com.exceptions.RitzkidsException;

public interface GuestList_Service 
{
	public ResponseWrapperDto getGuest(SearchDataDto  sdto) throws RitzkidsException;
}
