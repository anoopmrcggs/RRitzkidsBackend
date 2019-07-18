package com.rcg.com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RelationshipDto 
{
	private int rid;
	@NotNull
	@NotBlank(message = "Relationship ship name should not be balnk")
	private String name;

	
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
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
