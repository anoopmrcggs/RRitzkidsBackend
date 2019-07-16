package com.rcg.com.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.rcg.com.dao.Language;

public class ConsentFormDto 
{
	@ManyToOne
	private Language language;
	@NotNull
	@NotBlank(message = "Concern form data should not be empty")
	private String data;
	


	public Language getLanguage() 
	{
		return language;
	}

	public void setLanguage(Language language) 
	{
		this.language = language;
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}
	
	
}
