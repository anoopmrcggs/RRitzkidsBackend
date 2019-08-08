package com.rcg.com.dto;

import java.util.Date;


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
	private Boolean isActive;
	private Boolean isCheckedout;
	private String priority;
	private String location;

	
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
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Boolean getIsCheckedout() {
		return isCheckedout;
	}
	public void setIsCheckedout(Boolean isCheckedout) {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
}
