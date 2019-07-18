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
@Table(name="ryg_medical_details")
public class MedicalDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int medicaldetails_id;
	
	private Date created;
	private Date updated;
	
	
	private String medications;
	private String allergies;
	
	private String medication_allergies;
	private String special_needs;
	private String likes;
	private String dislikes;
	private String recurring_messages;
	
	@ManyToOne
	private YoungGust younggust;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	@JsonBackReference
	private CheckInCheckOut checkedincheckout;
	

	private int createdby;
	
	private int updatedby;
	private boolean isactive;
	
	public MedicalDetails() 
	{
		super();
	}


	public MedicalDetails(int medicaldetails_id, YoungGust younggust) {
		super();
		this.medicaldetails_id = medicaldetails_id;
		this.younggust = younggust;
	}

	public int getMedicaldetails_id() {
		return medicaldetails_id;
	}

	public void setMedicaldetails_id(int medicaldetails_id) {
		this.medicaldetails_id = medicaldetails_id;
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


	public String getMedication_allergies() {
		return medication_allergies;
	}

	public void setMedication_allergies(String medication_allergies) {
		this.medication_allergies = medication_allergies;
	}

	public String getSpecial_needs() {
		return special_needs;
	}

	public void setSpecial_needs(String special_needs) {
		this.special_needs = special_needs;
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

	public String getRecurring_messages() {
		return recurring_messages;
	}

	public void setRecurring_messages(String recurring_messages) {
		this.recurring_messages = recurring_messages;
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

	public CheckInCheckOut getCheckedincheckout() {
		return checkedincheckout;
	}

	public void setCheckedincheckout(CheckInCheckOut checkedincheckout) {
		this.checkedincheckout = checkedincheckout;
	}
	
	
	public YoungGust getYounggust() {
		return younggust;
	}

	public void setYounggust(YoungGust younggust) {
		this.younggust = younggust;
	}

}
