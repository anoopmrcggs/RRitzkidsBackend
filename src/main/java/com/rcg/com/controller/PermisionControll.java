package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Permission;
import com.rcg.com.dto.PermissionDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Permission_ServiceImpl;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/ritzkids")
public class PermisionControll 
{
	@Autowired
	private Permission_ServiceImpl ps;
	
	@RequestMapping(method=RequestMethod.POST,value="/permission")
	public ResponseEntity<?> save(@RequestBody PermissionDto p) throws RitzkidsException
	{		
		ps.save(p);
		return ResponseEntity.ok(new ResponseStatus<Permission>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping("/permission")
	public ResponseEntity<?> getAll() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<Permission>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS, ps.getAllPermission()));
	}
	
}
