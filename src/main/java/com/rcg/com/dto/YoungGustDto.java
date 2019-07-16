package com.rcg.com.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.rcg.com.dao.Guardian;


public class YoungGustDto 
{

	private int younggust_id;
	private int cabin;
	private int createdby;
	private int updatedby;
	
	private String firstname;
	private String lastname;
	private String language;
	private String nationality;
	private String shipcode;
	
	private Date birthdate;
	private Date created;
	private Date updated;

	
	private long bookingid;
	private long folioid;
	
	private char gender;
	private char passengertype;
	
	private boolean isactive;
	
	@ManyToMany(mappedBy = "young_gust")
	private Set<Guardian> guardian;
	

	
	
	public int getYounggust_id() {
		return younggust_id;
	}

	public void setYounggust_id(int younggust_id) {
		this.younggust_id = younggust_id;
	}

	public int getCabin() {
		return cabin;
	}

	public void setCabin(int cabin) {
		this.cabin = cabin;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getShipcode() {
		return shipcode;
	}

	public void setShipcode(String shipcode) {
		this.shipcode = shipcode;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public long getBookingid() {
		return bookingid;
	}

	public void setBookingid(long bookingid) {
		this.bookingid = bookingid;
	}

	public long getFolioid() {
		return folioid;
	}

	public void setFolioid(long folioid) {
		this.folioid = folioid;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getPassengertype() {
		return passengertype;
	}

	public void setPassengertype(char passengertype) {
		this.passengertype = passengertype;
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



	public boolean isIsactive() {
		return isactive;
	}



	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Set<Guardian> getGuardian() {
		return guardian;
	}

	public void setGuardian(Set<Guardian> guardian) {
		this.guardian = guardian;
	}
	
	

	
}
