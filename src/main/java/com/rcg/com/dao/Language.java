package com.rcg.com.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ryg_language")
public class Language 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private String name;
	private String rep;
	
	
	
	public Language() 
	{
		super();
	}

	public Language(int lid, String name, String rep) 
	{
		super();
		this.lid = lid;
		this.name = name;
		this.rep = rep;
	}
	
	public int getLid() 
	{
		return lid;
	}
	public void setLid(int lid) 
	{
		this.lid = lid;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getRep() 
	{
		return rep;
	}
	public void setRep(String rep) 
	{
		this.rep = rep;
	}
	
	
}
