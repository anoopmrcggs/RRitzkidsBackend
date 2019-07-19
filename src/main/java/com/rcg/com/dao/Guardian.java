package com.rcg.com.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
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
	@Column(name="guardian_id")
	private int guardianId;
	
	private int cabin;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="updated_by")
	private int updatedBy;
	
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
	
	@Column(name="contact_number")
	private String contectNumber;
	
	@ManyToMany
	@Column(name = "young_gust")
	private Set<YoungGust> youngGust;
	
	
	public Guardian() 
	{
		super();
	}



	public Guardian(int guardianId) 
	{
		super();
		this.guardianId = guardianId;
	}





	public Guardian(int guardianId, int cabin, int createdBy, int updatedBy, String firstName, String lastName,
			String language, String nationality, String shipCode, Date birthDate, Date created, Date updated,
			long bookingId, long folioId, char gender, char passengerType, boolean isActive, Set<YoungGust> youngGust) {
		super();
		this.guardianId = guardianId;
		this.cabin = cabin;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.nationality = nationality;
		this.shipCode = shipCode;
		this.birthDate = birthDate;
		this.created = created;
		this.updated = updated;
		this.bookingId = bookingId;
		this.folioId = folioId;
		this.gender = gender;
		this.passengerType = passengerType;
		this.isActive = isActive;
		this.youngGust = youngGust;
	}



	public int getGuardianId() {
		return guardianId;
	}



	public void setGuardianId(int guardianId) {
		this.guardianId = guardianId;
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



	public Set<YoungGust> getYoungGust() {
		return youngGust;
	}



	public void setYoungGust(Set<YoungGust> youngGust) {
		this.youngGust = youngGust;
	}



	public String getContectNumber() {
		return contectNumber;
	}



	public void setContectNumber(String contectNumber) {
		this.contectNumber = contectNumber;
	}
	
	
	
}
