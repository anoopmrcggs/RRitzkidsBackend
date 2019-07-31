package com.rcg.com.service;

import javax.xml.ws.ResponseWrapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rcg.com.dto.DataDto;
import com.rcg.com.dto.GuestListDto;
import com.rcg.com.dto.ResponseWrapperDto;
import com.rcg.com.dto.SearchDataDto;
import com.rcg.com.exceptions.RitzkidsException;

@Service
public class GuestList_ServiceImpl implements GuestList_Service 
{
	private final String  url="http://192.168.15.245:8082/ritzkids/api/getGuestDetails";

	@Override
	public ResponseWrapperDto getGuest(SearchDataDto  sdto) throws RitzkidsException 
	{
		
		RestTemplate restTemplate =new RestTemplate();
		ResponseWrapperDto dataDto=restTemplate.postForObject(url,sdto,ResponseWrapperDto.class);
		
		return dataDto;
	}

}
