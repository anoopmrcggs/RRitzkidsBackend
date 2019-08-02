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
@Table(name="ryg_consentform_template")
public class ConsentFormTemplate 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cfid;
	@ManyToOne
	@JsonBackReference
	private Language language;
	
	@Lob 
	@Column(length = 2000)
	private String head;
	@Lob 
	@Column(length = 2000)
	private String body;
	@Lob 
	@Column(length = 2000)
	private String item;
	
	public ConsentFormTemplate() 
	{
		super();
	}

	public ConsentFormTemplate(int cfid, Language language, String head, String body, String item) 
	{
		super();
		this.cfid = cfid;
		this.language = language;
		this.head = head;
		this.body = body;
		this.item = item;
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

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBoady() {
		return body;
	}

	public void setBoady(String body) {
		this.body = body;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	
	
}
