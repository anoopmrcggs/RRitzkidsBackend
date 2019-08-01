package com.rcg.com.dto;

public class YoungGustCheckinStatusDto 
{
	private long folioID;
	private long checkinID;
	private Boolean status;
	
	public long getFolioID() 
	{
		return folioID;
	}
	
	public void setFolioID(long folioID) 
	{
		this.folioID = folioID;
	}
	
	public long getCheckinID() 
	{
		return checkinID;
	}
	
	public void setCheckinID(long checkinID) 
	{
		this.checkinID = checkinID;
	}
	
	public Boolean getStatus() 
	{
		return status;
	}
	
	public void setStatus(Boolean status) 
	{
		this.status = status;
	}
	
	
}
