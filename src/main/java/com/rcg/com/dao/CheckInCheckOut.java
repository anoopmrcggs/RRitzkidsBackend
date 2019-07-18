package com.rcg.com.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="ryg_checkin_checkout")
public class CheckInCheckOut 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int checkin_checkout_id;
	
	private String nicname;
	private int tagid;
	private String event;
	
	private Date entrytime;
	private Date exittime;
	
	
	@ManyToOne
	private YoungGust younggust;
	
	@ManyToOne
	private Language language;
	
	@OneToMany(mappedBy = "checkincheckout")
	private Set<YoungGustNotes> younggustnotes;
	
	@OneToMany(mappedBy ="checkedincheckout")
	private Set<MedicalDetails> medicaldetails;
	
	@OneToMany(mappedBy = "checkincheckout")
	private Set<AuthorizedRelation> autorized_relation;
	
	
	private Date created;
	private Date updated;
	private int createdby;
	
	private int updatedby;
	private boolean isactive;
	
	

	public CheckInCheckOut() 
	{
		super();
	}



	public CheckInCheckOut(int checkin_checkout_id, String nicname, int tagid, YoungGust younggust, Language language,
			 Set<AuthorizedRelation> autorized_relation, int createdby) {
		super();
		this.checkin_checkout_id = checkin_checkout_id;
		this.nicname = nicname;
		this.tagid = tagid;
		this.younggust = younggust;
		this.language = language;
		this.autorized_relation = autorized_relation;
		this.createdby = createdby;
	}



	public CheckInCheckOut(int checkin_checkout_id) {
		super();
		this.checkin_checkout_id = checkin_checkout_id;
	}



	public int getCheckin_checkout_id() {
		return checkin_checkout_id;
	}



	public void setCheckin_checkout_id(int checkin_checkout_id) {
		this.checkin_checkout_id = checkin_checkout_id;
	}



	public String getNicname() {
		return nicname;
	}



	public void setNicname(String nicname) {
		this.nicname = nicname;
	}



	public int getTagid() {
		return tagid;
	}



	public void setTagid(int tagid) {
		this.tagid = tagid;
	}



	public String getEvent() {
		return event;
	}



	public void setEvent(String event) {
		this.event = event;
	}



	public YoungGust getYounggust() {
		return younggust;
	}



	public void setYounggust(YoungGust younggust) {
		this.younggust = younggust;
	}



	public Language getLanguage() {
		return language;
	}



	public void setLanguage(Language language) {
		this.language = language;
	}



	public Set<YoungGustNotes> getYounggustnotes() {
		return younggustnotes;
	}



	public void setYounggustnotes(Set<YoungGustNotes> younggustnotes) {
		this.younggustnotes = younggustnotes;
	}



	public Set<MedicalDetails> getMedicaldetails() {
		return medicaldetails;
	}



	public void setMedicaldetails(Set<MedicalDetails> medicaldetails) {
		this.medicaldetails = medicaldetails;
	}



	public Set<AuthorizedRelation> getAutorized_relation() {
		return autorized_relation;
	}



	public void setAutorized_relation(Set<AuthorizedRelation> autorized_relation) {
		this.autorized_relation = autorized_relation;
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



	public Date getEntrytime() {
		return entrytime;
	}



	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}



	public Date getExittime() {
		return exittime;
	}



	public void setExittime(Date exittime) {
		this.exittime = exittime;
	}




}