package com.rcg.com.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.Relationship;

public class AuthorizedRelationDto 
{
	private int aid;
	
	
	@ManyToOne
	private GuardianDto guardian;
	
	@ManyToOne
	private RelationshipDto relationship;
	
	@ManyToOne(targetEntity = CheckInCheckOutDto.class)
	@JsonBackReference
	private CheckInCheckOutDto checkincheckout;
	
	
	private Date created;
	private Date updated;
	private int createdby;
	private int updatedby;
	private boolean isactive;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public GuardianDto getGuardian() {
		return guardian;
	}
	public void setGuardian(GuardianDto guardian) {
		this.guardian = guardian;
	}
	public RelationshipDto getRelationship() {
		return relationship;
	}
	public void setRelationship(RelationshipDto relationship) {
		this.relationship = relationship;
	}
	public CheckInCheckOutDto getCheckincheckout() {
		return checkincheckout;
	}
	public void setCheckincheckout(CheckInCheckOutDto checkincheckout) {
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
