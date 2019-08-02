package com.rcg.com.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ryg_relationship")
public class Relationship 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rid;
	private String name;
	
	public Relationship() 
	{
		super();
	}

	public Relationship(int rid, String name) 
	{
		super();
		this.rid = rid;
		this.name = name;
	}

	public int getRid() 
	{
		return rid;
	}

	public void setRid(int rid) 
	{
		this.rid = rid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	

}
