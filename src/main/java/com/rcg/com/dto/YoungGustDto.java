package com.rcg.com.dto;

import java.util.Date;
import java.util.Set;



public class YoungGustDto 
{

private int youngGustId;
	
	private int cabin;
	private int createdBy;
	private int updatedBy;
	private String nickName;
	private String firstName;
	private String lastName;
	private String language;
	private String nationality;
	private String shipCode;
	private Date birthDate;
	private Date created;
	private Date updated;
	private long bookingId;
	private long folioId;
	private char gender;
	private char passengerType;
	private boolean isActive;
	private Set<GuardianDto> guardian;
	private String location;
	private String ageGroup;


	
	public int getYoungGustId() {
		return youngGustId;
	}
	public void setYoungGustId(int youngGustId) {
		this.youngGustId = youngGustId;
	}
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public long getFolioId() {
		return folioId;
	}
	public void setFolioId(long folioId) {
		this.folioId = folioId;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Set<GuardianDto> getGuardian() {
		return guardian;
	}
	public void setGuardian(Set<GuardianDto> guardian) {
		this.guardian = guardian;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	
	
}
