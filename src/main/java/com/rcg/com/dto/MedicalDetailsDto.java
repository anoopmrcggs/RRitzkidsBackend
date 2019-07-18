package com.rcg.com.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rcg.com.dao.CheckInCheckOut;
import com.rcg.com.dao.YoungGust;

public class MedicalDetailsDto 
{

	private int medicaldetails_id;

	
	
	private String medications;
	private String allergies;
	
	private String medication_allergies;
	private String special_needs;
	private String likes;
	private String dislikes;
	private String recurring_messages;
	
	@ManyToOne
	private YoungGustDto younggustdto;
	
	@ManyToOne(targetEntity = CheckInCheckOut.class)
	private CheckInCheckOutDto checkedincheckoutdto;
	

	private Date created;
	private Date updated;
	private int createdby;
	private int updatedby;
	private boolean isactive;
	
	
	
	public int getMedicaldetails_id() {
		return medicaldetails_id;
	}
	public void setMedicaldetails_id(int medicaldetails_id) {
		this.medicaldetails_id = medicaldetails_id;
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
	public YoungGustDto getYounggustdto() {
		return younggustdto;
	}
	public void setYounggustdto(YoungGustDto younggustdto) {
		this.younggustdto = younggustdto;
	}
	public CheckInCheckOutDto getCheckedincheckoutdto() {
		return checkedincheckoutdto;
	}
	public void setCheckedincheckoutdto(CheckInCheckOutDto checkedincheckoutdto) {
		this.checkedincheckoutdto = checkedincheckoutdto;
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
