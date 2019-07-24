package com.rcg.com.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ryg_young_gust")
public class YoungGust 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="young_gust_id")
	private int youngGustId;
	
	private int cabin;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="nick_name")
	private String nickName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String language;
	private String nationality;
	
	@Column(name="ship_code")
	private String shipCode;

	@Column(name="birth_date")
	private Date birthDate;
	
	private Date created;
	private Date updated;

	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="folio_id")
	private long folioId;
	
	private char gender;
	
	@Column(name="passenger_type")
	private char passengerType;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToMany(mappedBy = "youngGust")
	@JsonBackReference
	private Set<Guardian> guardian;
	
	@Column(name="age_group")
	private String ageGroup;

	private String location;
	

	public YoungGust() 
	{
		super();
	}


	public YoungGust(int youngGustId) {
		super();
		this.youngGustId = youngGustId;
	}


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


	public Set<Guardian> getGuardian() {
		return guardian;
	}


	public void setGuardian(Set<Guardian> guardian) {
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