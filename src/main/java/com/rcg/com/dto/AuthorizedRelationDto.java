package com.rcg.com.dto;

import java.util.Date;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.Guardian;
import com.rcg.com.dao.Relationship;

public class AuthorizedRelationDto 
{
	
	private int authorizedRelationId;
	private GuardianDto guardian;
	private RelationshipDto relationship;
	private CheckInCheckOutDto checkinCheckout;
	private String contactNumber;
	private Date created;
	private Date updated;
	private int createdBy;
	private int updatedBy;
	private boolean isActive;
	private boolean isCheckedout;
	private String priority;

	
	public int getAuthorizedRelationId() {
		return authorizedRelationId;
	}
	public void setAuthorizedRelationId(int authorizedRelationId) {
		this.authorizedRelationId = authorizedRelationId;
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
