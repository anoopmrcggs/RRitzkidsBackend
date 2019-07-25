package com.rcg.com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.com.dao.Relationship;
import com.rcg.com.dto.RelationshipDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.service.Relationship_Service;
import com.rcg.com.util.ResponseStatus;
import com.rcg.com.util.RitzConstants;

@RestController
@RequestMapping("/api")
public class RelationshipController 
{
	@Autowired
	private Relationship_Service rs;
	
	//save Relationship
	@RequestMapping(method = RequestMethod.POST,value = "/relationship")
	public ResponseEntity<?> save(@Valid @RequestBody RelationshipDto rdto)
	{
		rs.saveRelationship(rdto);
		return ResponseEntity.ok(new ResponseStatus<Relationship>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
	//Get All Relationship
	@RequestMapping("/relationship")
	public ResponseEntity<?> getAll()
	{
		return ResponseEntity.ok(new ResponseStatus<List<Relationship>>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS,rs.getAllRelationship()));
	}
	//Get Relationship
	@RequestMapping("/relationship/{rid}") 
	public ResponseEntity<?> get(@PathVariable int rid) throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Relationship>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS,rs.getRelationship(rid)));
	}
	//Update Relationship
	@RequestMapping(method = RequestMethod.POST,value = "/relationship/{rid}")
	public ResponseEntity<?> update(@Valid @RequestBody RelationshipDto rdto) throws RitzkidsException,ConstraintsException
	{
		return ResponseEntity.ok(new ResponseStatus<Relationship>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
	//delete Relationship
	public ResponseEntity<?> delete() throws RitzkidsException
	{
		return ResponseEntity.ok(new ResponseStatus<Relationship>(RitzConstants.SUCCESS_CODE, RitzConstants.OK, RitzConstants.SUCCESS));
	}
}
