package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.Language;
import com.rcg.com.dto.LanguageDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;

public interface Language_Service 
{
	//Save Langugae
	public String saveLanguage(LanguageDto languagedto);
	//Get Language by ID
	public Language getLanguageById(int lid) throws RitzkidsException;
	//Get All Language
	public List<Language> getAllLanguage();
	//Update Language
	public String updateLanguage(LanguageDto ldto,int lid) throws RitzkidsException,ConstraintsException;
	//Delete Language
	public String deleteLanguage(int lid) throws RitzkidsException;
	
	
}
