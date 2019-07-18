package com.rcg.com.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.rcg.com.dao.AuthorizedRelation;
import com.rcg.com.dao.Language;
import com.rcg.com.dao.MedicalDetails;
import com.rcg.com.dao.YoungGust;
import com.rcg.com.dao.YoungGustNotes;

public class CheckInCheckOutDto 
{
	private int checkin_checkout_id;
	private String nicname;
	private int tagid;
	private String event;
	
	
	@ManyToOne
	private YoungGustDto younggustdto;
	
	@ManyToOne
	private LanguageDto languagedto;
	
	@OneToMany(mappedBy = "checkedincheckoutdto")
	private Set<YoungGustNotesDto> younggustnotesDto;
	
	@OneToMany(mappedBy ="checkedincheckoutdto")
	private Set<MedicalDetailsDto> medicaldetailsDto;
	
	@OneToMany(mappedBy = "checkedincheckoutdto")
	private Set<AuthorizedRelationDto> autorized_relationDto;
	
	
	private Date entrytime;
	private Date exittime;
	
	private Date created;
	private Date updated;
	private int createdby;
	private int updatedby;
	private boolean isactive;
	
	public int getCheckin_checkout_id() 
	{
		return checkin_checkout_id;
	}
	
	public void setCheckin_checkout_id(int checkin_checkout_id) 
	{
		this.checkin_checkout_id = checkin_checkout_id;
	}
	
	public String getNicname() 
	{
		return nicname;
	}
	
	public void setNicname(String nicname) 
	{
		this.nicname = nicname;
	}
	
	public int getTagid() 
	{
		return tagid;
	}
	
	public void setTagid(int tagid) 
	{
		this.tagid = tagid;
	}
	
	public String getEvent() 
	{
		return event;
	}
	public void setEvent(String event)
	{
		this.event = event;
	}
	public YoungGustDto getYounggustdto() 
	{
		return younggustdto;
	}
	public void setYounggustdto(YoungGustDto younggustdto) 
	{
		this.younggustdto = younggustdto;
	}
	public LanguageDto getLanguagedto() 
	{
		return languagedto;
	}
	public void setLanguagedto(LanguageDto languagedto) 
	{
		this.languagedto = languagedto;
	}
	public Set<YoungGustNotesDto> getYounggustnotesDto() 
	{
		return younggustnotesDto;
	}
	public void setYounggustnotesDto(Set<YoungGustNotesDto> younggustnotesDto) 
	{
		this.younggustnotesDto = younggustnotesDto;
	}
	public Set<MedicalDetailsDto> getMedicaldetailsDto() 
	{
		return medicaldetailsDto;
	}
	public void setMedicaldetailsDto(Set<MedicalDetailsDto> medicaldetailsDto) 
	{
		this.medicaldetailsDto = medicaldetailsDto;
	}
	public Set<AuthorizedRelationDto> getAutorized_relationDto() 
	{
		return autorized_relationDto;
	}
	public void setAutorized_relationDto(Set<AuthorizedRelationDto> autorized_relationDto) 
	{
		this.autorized_relationDto = autorized_relationDto;
	}
	public Date getCreated() 
	{
		return created;
	}
	public void setCreated(Date created) 
	{
		this.created = created;
	}
	public Date getUpdated() 
	{
		return updated;
	}
	public void setUpdated(Date updated) 
	{
		this.updated = updated;
	}
	public int getCreatedby() 
	{
		return createdby;
	}
	public void setCreatedby(int createdby) 
	{
		this.createdby = createdby;
	}
	public int getUpdatedby() 
	{
		return updatedby;
	}
	public void setUpdatedby(int updatedby) 
	{
		this.updatedby = updatedby;
	}
	public boolean isIsactive() 
	{
		return isactive;
	}
	public void setIsactive(boolean isactive) 
	{
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
