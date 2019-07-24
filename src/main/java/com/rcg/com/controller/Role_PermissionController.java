package com.rcg.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.RoleMapping_ServiceImpl;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class Role_PermissionController 
{
	@Autowired
	private RoleMapping_ServiceImpl rms;
	
	//Role Permission Assigning 
	@RequestMapping(method = RequestMethod.PUT,value="/rolepermission/rid/{rid}/pid/{pid}")
	public ResponseEntity<?> saveRelationShip(@PathVariable int rid,@PathVariable int pid) throws RitzkidsException
	{
		rms.rolePermissionMapping(rid, pid);
		return ResponseEntity.ok(new ResponseStatus<>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
		
	}
}
