package com.rcg.com.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name="ryg_event_log")
public class EventLog 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_log_id")
	private int eventLogId;
	
	@ManyToOne
	private YoungGust youngGust;
	
	private String title;

	private String description;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOut checkinCheckout;
	
	private Date created;
	private Date updated;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="update_dby")
	private int updatedBy;
	
	@Column(name="is_active")
	private boolean isActive;
	

	public int getEventLogId() {
		return eventLogId;
	}

	public void setEventLogId(int eventLogId) {
		this.eventLogId = eventLogId;
	}

	public YoungGust getYoungGust() {
		return youngGust;
	}

	public void setYoungGust(YoungGust youngGust) {
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

	public CheckInCheckOut getCheckinCheckout() {
		return checkinCheckout;
	}

	public void setCheckinCheckout(CheckInCheckOut checkinCheckout) {
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
