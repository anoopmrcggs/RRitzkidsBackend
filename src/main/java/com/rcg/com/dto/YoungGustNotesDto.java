package com.rcg.com.dto;

import java.util.Date;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.YoungGust;

public class YoungGustNotesDto 
{
	
	private int youngGustNotesId;
	private YoungGustDto youngGust;
	private String title;
	private String description;
	private CheckInCheckOutDto checkinCheckout;
	private Date created;
	private Date updated;
	private int createdBy;
	private int updatedBy;
	private boolean isActive;
	
	public int getYoungGustNotesId() 
	{
		return youngGustNotesId;
	}
	public void setYoungGustNotesId(int youngGustNotesId) {
		this.youngGustNotesId = youngGustNotesId;
	}
	public YoungGustDto getYoungGust() {
		return youngGust;
	}
	public void setYoungGust(YoungGustDto youngGust) {
		this.youngGust = youngGust;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CheckInCheckOutDto getCheckinCheckout() {
		return checkinCheckout;
	}
	public void setCheckinCheckout(CheckInCheckOutDto checkinCheckout) {
		this.checkinCheckout = checkinCheckout;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
