package com.rcg.com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LanguageDto 
{

	@NotNull
	@NotBlank(message = "Name of language should not be blank")
	private String name;
	private String rep;
	
	
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
