package com.rcg.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Role;
import com.rcg.com.dto.RoleDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Role_Service;
import com.rcg.com.service.Role_ServiceImpl;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class RoleControll 
{
	@Autowired
	private Role_ServiceImpl rs;
	
	@RequestMapping(method=RequestMethod.POST,value="/role")
	public ResponseEntity<?> save(@RequestBody RoleDto role) throws RitzkidsException
	{
		rs.save(role);
		return ResponseEntity.ok(new ResponseStatus<Role>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS));
	}
	
	@RequestMapping("/role")
	public ResponseEntity<?> getAll() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<List<Role>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK,RitzConstants.SUCCESS,rs.getAllRole()));
	}
	
	/*
	 * @RequestMapping() public String saveRoleWithPermision() throws
	 * RitzkidsException {
	 * 
	 * return "success"; }
	 */
}
