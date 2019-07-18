package com.rcg.com.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name="ryg_YoungGustNotes")
public class YoungGustNotes 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int younggustnotes_id;
	
	@ManyToOne
	private YoungGust younggust;
	
	private String title;

	private String description;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOut checkincheckout;
	
	private Date created;
	private Date updated;
	private int createdby;
	private int updatedby;
	private boolean isactive;
	
	public YoungGustNotes() 
	{
		super();
	}

	public YoungGustNotes(int younggustnotes_id, YoungGust younggust, String title, String description,
			CheckInCheckOut checkincheckout, Date created) 
	{
		super();
		this.younggustnotes_id = younggustnotes_id;
		this.younggust = younggust;
		this.title = title;
		this.description = description;
		this.checkincheckout = checkincheckout;
		this.created = created;
	}

	public int getYounggustnotes_id() {
		return younggustnotes_id;
	}

	public void setYounggustnotes_id(int younggustnotes_id) {
		this.younggustnotes_id = younggustnotes_id;
	}

	public YoungGust getYounggust() {
		return younggust;
	}

	public void setYounggust(YoungGust younggust) {
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

	public CheckInCheckOut getCheckincheckout() {
		return checkincheckout;
	}

	public void setCheckincheckout(CheckInCheckOut checkincheckout) {
		this.checkincheckout = checkincheckout;
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
