package com.rcg.com.service;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rcg.com.dto.AuthDto;
import com.rcg.com.dto.ResponseWrapperDto;
import com.rcg.com.dto.SearchDataDto;
import com.rcg.com.dto.TokenDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.util.RitzConstants;

@Service
public class GuestList_ServiceImpl implements GuestList_Service 
{
	
	@Autowired
	private MiddleWareToken_Service mts;
	
	private final String  url="http://192.168.15.245:8082/authenticate/auth-token";
	//private final String  aurl=System.getenv("MIDDLEWARE_API_URL")+"/ritzkids/api/getGuestDetails";
	private final String  durl=System.getenv("MIDDLEWARE_API_URL")+"/ritzkids/api/getGuestDetails";
	
	private String token;
	
	private static final String userName="ritzkids123";
	private static final String password="ritzkids@123";
	
	public String getToken()
	{
		AuthDto adto=new AuthDto(userName, password);
		RestTemplate restTemplate =new RestTemplate();
		TokenDto respo=restTemplate.postForObject(url,adto,TokenDto.class);
		
		return respo.getToken();
	}
	
	
	
	

	@Override
	public ResponseWrapperDto getGuest(SearchDataDto  sdto) throws RitzkidsException 
	{
		ResponseWrapperDto dataDto=null;
		if(sdto.getEmployeeId()>0)
		{
			try {
				
				token=getToken();
				//token=mts.getToken(sdto.getEmployeeId());
				HttpHeaders headers=new HttpHeaders();
				headers.add("Authorization", "Bearer "+token);
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
				HttpEntity<SearchDataDto> entity=new HttpEntity<SearchDataDto>(sdto, headers);
				RestTemplate restTemplate =new RestTemplate();
				dataDto=restTemplate.postForObject(durl,entity,ResponseWrapperDto.class);
				
				if(dataDto.getCode()!=401)
				{
					System.out.println("Auth Valid");
				}
				
			}catch (Exception e) {throw new RitzkidsException("Invalid Authorization", RitzConstants.ERROR_CODE);}
		}
		else
		{
			throw new RitzkidsException("EmployeeID not found or 0", RitzConstants.ERROR_CODE);
		}
		
		return dataDto;	
	}

}
