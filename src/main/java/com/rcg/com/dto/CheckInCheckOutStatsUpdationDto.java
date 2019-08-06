package com.rcg.com.dto;

public class CheckInCheckOutStatsUpdationDto 
{
	private int checkinID;
	private int authorizedID;
	private int updatedBy;
	private Boolean status;
	
	
	
	public int getUpdatedBy() 
	{
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) 
	{
		this.updatedBy = updatedBy;
	}
	
	public int getCheckinID() {
		return checkinID;
	}

	public void setCheckinID(int checkinID) {
		this.checkinID = checkinID;
	}

	public int getAuthorizedID() 
	{
		return authorizedID;
	}
	
	public void setAuthorizedID(int authorizedID) 
	{
		this.authorizedID = authorizedID;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
