package com.rcg.com.dto;

import java.util.Date;


public class PassengerListDto 
{
	
	private int cabin;
	private int createdBy;
	private int updatedBy;
	
	private String firstName;
	private String lastName;
	private String language;
	private String nationality;
	private String shipCode;
	
	private Date birthDate;
	private Date created;
	private Date updated;

	
	private long bookingID;
	private long folioID;
	
	private char gender;
	private char passengerType;
	
	private Boolean  isctive;

	public int getCabin() {
		return cabin;
	}

	public void setCabin(int cabin) {
		this.cabin = cabin;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public long getFolioID() {
		return folioID;
	}

	public void setFolioID(long folioID) {
		this.folioID = folioID;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(char passengerType) {
		this.passengerType = passengerType;
	}

	public Boolean getIsctive() {
		return isctive;
	}

	public void setIsctive(Boolean isctive) {
		this.isctive = isctive;
	}
	
	
	
}