package com.rcg.com.dao;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
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
	@Column(name="authorized_relation_id")
	private int authorizedRelationId;
	
	
	@ManyToOne
	@JsonIgnoreProperties("youngGust")
	private Guardian guardian;
	
	@ManyToOne
	private Relationship relationship;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOut checkinCheckout;
	
	
	private Date created;
	private Date updated;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="is_Active")
	private boolean isActive;
	
	@Column(name="is_checkedout")
	private boolean isCheckedout;
	
	@Column(name="contact_number")
	private String contactNumber;
	
	@Column(name="priority")
	private String priority;

	
	public AuthorizedRelation() 
	{
		super();
	}

	


	public AuthorizedRelation(int authorizedRelationId, Guardian guardian, Relationship relationship, CheckInCheckOut checkinCheckout,
			int createdby) {
		super();
		this.authorizedRelationId = authorizedRelationId;
		this.guardian = guardian;
		this.relationship = relationship;
		this.checkinCheckout = checkinCheckout;
	}




	public int getAuthorizedRelationId() {
		return authorizedRelationId;
	}

	public void setAuthorizedRelationId(int authorizedRelationId) {
		this.authorizedRelationId = authorizedRelationId;
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




	public boolean isCheckedout() {
		return isCheckedout;
	}




	public void setCheckedout(boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}




	public String getContactNumber() {
		return contactNumber;
	}




	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}




	public String getPriority() {
		return priority;
	}




	public void setPriority(String priority) {
		this.priority = priority;
	}

	
}
