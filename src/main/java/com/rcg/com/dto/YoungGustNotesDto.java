package com.rcg.com.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.YoungGust;

public class YoungGustNotesDto 
{
	
	private int younggustnotes_id;
	

	@ManyToOne
	private YoungGustDto younggust;
	
	private String title;

	private String description;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOutDto checkincheckoutdto;
	
	private Date created;
	private Date updated;
	
	private int createdby;
	
	private int updatedby;
	private boolean isactive;
	public int getYounggustnotes_id() {
		return younggustnotes_id;
	}
	public void setYounggustnotes_id(int younggustnotes_id) {
		this.younggustnotes_id = younggustnotes_id;
	}
	
	public YoungGustDto getYounggust() {
		return younggust;
	}
	public void setYounggust(YoungGustDto younggust) {
		this.younggust = younggust;
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
	public CheckInCheckOutDto getCheckincheckoutdto() {
		return checkincheckoutdto;
	}
	public void setCheckincheckoutdto(CheckInCheckOutDto checkincheckoutdto) {
		this.checkincheckoutdto = checkincheckoutdto;
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
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public int getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
}
