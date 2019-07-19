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
@Table(name="ryg_medical_details")
public class MedicalDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_details_id")
	private int medicalDetailsId;
	
	private Date created;
	private Date updated;
	
	
	private String medications;
	private String allergies;
	
	@Column(name="medication_allergies")
	private String medicationAllergies;
	
	@Column(name="special_needs")
	private String specialNeeds;
	private String likes;
	private String dislikes;
	
	@ManyToOne
	@Column(name="young_gust")
	private YoungGust youngGust;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	@Column(name="checkedin_checkout")
	private CheckInCheckOut checkinCheckout;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="is_active")
	private boolean isActive;
	
	public MedicalDetails() 
	{
		super();
	}


	public MedicalDetails(int medicalDetailsId, YoungGust youngGust)
	{
		super();
		this.medicalDetailsId = medicalDetailsId;
		this.youngGust = youngGust;
	}


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


	public YoungGust getYoungGust() {
		return youngGust;
	}


	public void setYoungGust(YoungGust youngGust) {
		this.youngGust = youngGust;
	}


	public CheckInCheckOut getCheckinCheckout() {
		return checkinCheckout;
	}


	public void setCheckinCheckout(CheckInCheckOut checkinCheckout) {
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
