package com.rcg.com.dto;

public class CheckInCheckOutStatsUpdationDto 
{
	private int chechinID;
	private int authorizedID;
	private int updatedBy;
	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	private Boolean Status;
	
	public int getChechinID() 
	{
		return chechinID;
	}
	
	public void setChechinID(int chechinID) 
	{
		this.chechinID = chechinID;
	}
	
	public int getAuthorizedID() 
	{
		return authorizedID;
	}
	
	public void setAuthorizedID(int authorizedID) 
	{
		this.authorizedID = authorizedID;
	}
	
	public Boolean getStatus()
	{
		return Status;
	}
	
	public void setStatus(Boolean status) 
	{
		Status = status;
	}
}
