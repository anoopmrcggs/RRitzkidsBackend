package com.rcg.com.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ryg_consentform")
public class ConsentForm 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cfid;
	@ManyToOne
	@JsonBackReference
	private Language language;
	
	@Lob 
	@Column(length = 2000)
	private String data;
	
	public ConsentForm() 
	{
		super();
	}

	public ConsentForm(int cfid, int l_id, String data) 
	{
		super();
		this.cfid = cfid;
		this.data = data;
		this.language = new Language(l_id," ", " ");
	}

	public int getCfid() {
		return cfid;
	}

	public void setCfid(int cfid) {
		this.cfid = cfid;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
