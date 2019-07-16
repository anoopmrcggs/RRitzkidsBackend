package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Relationship;
import com.rcg.com.dto.RelationshipDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;

public interface Relationship_Service 
{
	//Save Relationship
	public String saveRelationship(RelationshipDto relationshipdto);
	
	//Get Relationship by id
	public Relationship getRelationship(int rid)throws RitzkidsException;
	
	//Get All RelationShip
	public List<Relationship> getAllRelationship();
	
	//Update Relationship
	public String updateRelationship(RelationshipDto relationshipdto,int rid) throws RitzkidsException,ConstraintsException;
	
	//Delete Relationship
	public String deleteRelationship(int rid) throws RitzkidsException;
}
