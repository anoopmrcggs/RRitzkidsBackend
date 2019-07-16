package com.rcg.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.Language;
import com.rcg.com.dto.LanguageDto;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class Language_ServiceImpl implements Language_Service 
{

	@Autowired
	private LanguageRepository lr;
	
	@Override
	public String saveLanguage(LanguageDto ldto) 
	{
		Language l=languageMapper(ldto);
		lr.save(l);
		
		return "Operation Completed";
	}

	@Override
	public Language getLanguageById(int lid) throws RitzkidsException
	{
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("Invalid language ID foud", RitzConstants.ERROR_CODE);
		}
		else
		{
			return language.get();
		}
	}

	@Override
	public List<Language> getAllLanguage() 
	{
		List<Language> l=new ArrayList<Language>();
		lr.findAll().forEach(l::add);
		return l;
	}

	@Override
	public String updateLanguage(LanguageDto ldto,int lid) throws RitzkidsException,ConstraintsException 
	{
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("Invalid language ID found", RitzConstants.ERROR_CODE);
		}
		else
		{
			Language l=languageMapper(ldto);
			l.setLid(lid);
			lr.save(l);
			return "Operation Completed";
		}
	}

	@Override
	public String deleteLanguage(int lid) throws RitzkidsException
	{
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("Invalid language ID found", RitzConstants.ERROR_CODE);
		}
		else
		{
			lr.deleteById(lid);
			return "Operation Completed";
		}
		
	}
	
	private Language languageMapper(LanguageDto ldto)
	{
		ModelMapper mapper=new ModelMapper();
		Language l=mapper.map(ldto, Language.class);
		return l;
	}

}
