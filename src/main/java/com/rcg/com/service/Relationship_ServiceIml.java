package com.rcg.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Relation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Relationship;
import com.rcg.com.dto.RelationshipDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.RelationshipRepository;

@Service
public class Relationship_ServiceIml implements Relationship_Service 
{
	@Autowired
	private RelationshipRepository rr;

	@Override
	public String saveRelationship(RelationshipDto relationshipdto) 
	{
		Relationship r=relationshipMapper(relationshipdto);
		rr.save(r);
		return "Operation Completed";
	}

	@Override
	public Relationship getRelationship(int rid) throws RitzkidsException
	{
		Optional<Relationship> relationship=rr.findById(rid);
		if(!relationship.isPresent())
		{
			throw new RitzkidsException("Invalid relationship id",HttpStatus.NOT_FOUND.value());
		}
		else
		{
			return relationship.get();
		}
		
	}

	@Override
	public List<Relationship> getAllRelationship() 
	{
		List<Relationship> relation=new ArrayList<Relationship>();
		rr.findAll().forEach(relation::add);
		return relation;
	}

	@Override
	public String updateRelationship(RelationshipDto relationshipdto,int rid) throws RitzkidsException,ConstraintsException
	{
		Optional<Relationship> relationship=rr.findById(rid);
		if(!relationship.isPresent())
		{
			throw new RitzkidsException("Invalid relationship id", HttpStatus.NOT_FOUND.value());
		}
		else
		{
			Relationship r=relationshipMapper(relationshipdto);
			r.setRid(rid);
			rr.save(r);
			return "Operation Completed";
		}
	}

	@Override
	public String deleteRelationship(int rid) throws RitzkidsException
	{
		Optional<Relationship> relationship=rr.findById(rid);
		if(!relationship.isPresent())
		{
			throw new RitzkidsException("Invalid relationship id", HttpStatus.NOT_FOUND.value());
		}
		else
		{
			rr.deleteById(rid);
			return "Operation Completed";
		}
	}
	
	private Relationship relationshipMapper(RelationshipDto rdto)
	{
		ModelMapper mapper=new ModelMapper();
		return mapper.map(rdto,Relationship.class);
	}

}
