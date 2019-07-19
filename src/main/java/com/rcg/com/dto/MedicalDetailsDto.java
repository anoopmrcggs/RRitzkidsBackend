package com.rcg.com.dto;

import java.util.Date;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.YoungGust;

public class MedicalDetailsDto 
{

	private int medicalDetailsId;
	private Date created;
	private Date updated;
	private String medications;
	private String allergies;
	private String medicationAllergies;
	private String specialNeeds;
	private String likes;
	private String dislikes;
	private YoungGustDto youngGust;
	private CheckInCheckOutDto checkinCheckout;
	private int createdBy;
	private int updatedBy;
	private boolean isActive;
	public int getMedicalDetailsId() {
		return medicalDetailsId;
	}
	public void setMedicalDetailsId(int medicalDetailsId) {
		this.medicalDetailsId = medicalDetailsId;
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
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMedicationAllergies() {
		return medicationAllergies;
	}
	public void setMedicationAllergies(String medicationAllergies) {
		this.medicationAllergies = medicationAllergies;
	}
	public String getSpecialNeeds() {
		return specialNeeds;
	}
	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getDislikes() {
		return dislikes;
	}
	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}
	public YoungGustDto getYoungGust() {
		return youngGust;
	}
	public void setYoungGust(YoungGustDto youngGust) {
		this.youngGust = youngGust;
	}
	public CheckInCheckOutDto getCheckinCheckout() {
		return checkinCheckout;
	}
	public void setCheckinCheckout(CheckInCheckOutDto checkinCheckout) {
		this.checkinCheckout = checkinCheckout;
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
