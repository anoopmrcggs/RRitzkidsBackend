package com.rcg.com.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ryg_medical_details")
public class MedicalDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medical_details_id")
	private int medicalDetailsId;
	
	private Date created;
	private Date updated;
	
	
	private String medications;
	private String allergies;
	
	@Column(name="medication_allergies")
	private String medicationAllergies;
	
	@Column(name="emergency_contact")
	private String emergencyContact;
	
	private String preferences;
	
	private String likes;
	private String dislikes;
	
	/*
	 * @ManyToOne private YoungGust youngGust;
	 */
	
	/*
	 * @ManyToOne(targetEntity = CheckInCheckOut.class)
	 * 
	 * @JsonBackReference private CheckInCheckOut checkinCheckout;
	 */
	
	@OneToOne
	@JsonBackReference
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


	public MedicalDetails(int medicalDetailsId)
	{
		super();
		this.medicalDetailsId = medicalDetailsId;
		
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


	public String getEmergencyContact() {
		return emergencyContact;
	}


	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}


	public String getPreferences() {
		return preferences;
	}


	public void setPreferences(String preferences) {
		this.preferences = preferences;
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
