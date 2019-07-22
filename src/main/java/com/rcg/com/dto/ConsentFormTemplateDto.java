package com.rcg.com.dto;

import com.rcg.com.dao.Language;

public class ConsentFormTemplateDto 
{
	private int cfid;
	private Language language;
	private String head;
	private String body;
	private String item;

	public int getCfid() 
	{
		return cfid;
	}

	public void setCfid(int cfid) 
	{
		this.cfid = cfid;
	}

	public Language getLanguage() 
	{
		return language;
	}

	public void setLanguage(Language language) 
	{
		this.language = language;
	}

	public String getHead() 
	{
		return head;
	}

	public void setHead(String head) 
	{
		this.head = head;
	}

	public String getBoady() 
	{
		return body;
	}

	public void setBody(String body) 
	{
		this.body = body;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	
	
}
