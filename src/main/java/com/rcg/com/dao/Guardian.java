package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="ryg_guardian")
public class Guardian 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int guardian_id;
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
	
	@ManyToMany
	private Set<YoungGust> young_gust;
	
	
	public Guardian() 
	{
		super();
	}



	public Guardian(int guardian_id) {
		super();
		this.guardian_id = guardian_id;
	}



	public Guardian(int guardian_id, int cabin, int createdby, int updatedby, String firstname, String lastname,
			String language, String nationality, String shipcode, Date birthdate, Date created, Date updated,
			long bookingid, long folioid, char gender, char passengertype, boolean isactive) {
		super();
		this.guardian_id = guardian_id;
		this.cabin = cabin;
		this.createdby = createdby;
		this.updatedby = updatedby;
		this.firstname = firstname;
		this.lastname = lastname;
		this.language = language;
		this.nationality = nationality;
		this.shipcode = shipcode;
		this.birthdate = birthdate;
		this.created = created;
		this.updated = updated;
		this.bookingid = bookingid;
		this.folioid = folioid;
		this.gender = gender;
		this.passengertype = passengertype;
		this.isactive = isactive;
	}



	public int getGuardian_id() {
		return guardian_id;
	}

	public void setGuardian_id(int guardian_id) {
		this.guardian_id = guardian_id;
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



	public Set<YoungGust> getYoung_gust() {
		return young_gust;
	}



	public void setYoung_gust(Set<YoungGust> young_gust) {
		this.young_gust = young_gust;
	}
	
	

	
}
