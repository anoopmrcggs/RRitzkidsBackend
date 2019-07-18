package com.rcg.com.dao;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ryg_authorizedRelation")
public class AuthorizedRelation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	
	@ManyToOne
	@JsonIgnoreProperties("young_gust")
	private Guardian guardian;
	
	@ManyToOne
	private Relationship relationship;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOut checkincheckout;
	
	
	private Date created;
	private Date updated;
	private int createdby;
	private int updatedby;
	private boolean isactive;


	
	public AuthorizedRelation() 
	{
		super();
	}

	


	public AuthorizedRelation(int aid, Guardian guardian, Relationship relationship, CheckInCheckOut checkincheckout,
			int createdby) {
		super();
		this.aid = aid;
		this.guardian = guardian;
		this.relationship = relationship;
		this.checkincheckout = checkincheckout;
		this.createdby = createdby;
	}




	public int getAid() {
		return aid;
	}



	public void setAid(int aid) {
		this.aid = aid;
	}



	public Guardian getGuardian() {
		return guardian;
	}



	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}



	public Relationship getRelationship() {
		return relationship;
	}



	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
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
