package com.rcg.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.com.dao.ConsentForm;
import com.rcg.com.dao.Language;
import com.rcg.com.dto.ConsentFormDto;
import com.rcg.com.exceptions.RitzkidsException;
import com.rcg.com.repository.ConCernFormRepository;
import com.rcg.com.repository.LanguageRepository;
import com.rcg.com.util.RitzConstants;

@Service
public class ConsentForm_ServiceImpl implements ConsentForm_Service{

	@Autowired
	private ConCernFormRepository cr;
	
	@Autowired 
	private LanguageRepository lr;
	
	@Override
	public String saveConsentForm(ConsentFormDto concernformdto,int lid) throws RitzkidsException
	{
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			ConsentForm cf=formMapper(concernformdto);
			cf.setLanguage(new Language(lid, "", ""));
			cr.save(cf);
			return "Operation Completed";
		}
	}

	@Override
	public ConsentForm getConsentFormById(int lid) throws RitzkidsException 
	{	
		Optional<Language> language=lr.findById(lid);
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in this ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			Optional< ConsentForm> cf=cr.getConCernFormBylanguageLid(lid);
			if(!cf.isPresent())
			{
				throw new RitzkidsException("No Consentform where found in given language ID", RitzConstants.ERROR_CODE);
			}
			else
			{
				return cf.get();
			}
	
		}
	}

	@Override
	public List<ConsentForm> getAllConsentForm() 
	{
		List<ConsentForm> concern=new ArrayList<ConsentForm>();
		cr.findAll().forEach(concern::add);
		return concern;
	}

	@Override
	public String updateConsentForm(ConsentFormDto concernformdto, int cid,int lid)  throws RitzkidsException
	{
		Optional<Language> language=lr.findById(lid);		
		if(!language.isPresent())
		{
			throw new RitzkidsException("No language where found in gien ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			Optional< ConsentForm> cf=cr.getConCernFormBylanguageLid(lid);
			if(!cf.isPresent())
			{
				throw new RitzkidsException("No consentform where found in gien ID", RitzConstants.ERROR_CODE);

			}
			else
			{
				ConsentForm cform=formMapper(concernformdto);
				cform.setCfid(cid);
				cr.save(cform);
				return "Operation Completed";
			}

		}

		
	}

	@Override
	public String deleteConsentForm(int cid) throws RitzkidsException
	{
		Optional< ConsentForm> cf=cr.getConCernFormBylanguageLid(cid);
		if(!cf.isPresent())
		{
			throw new RitzkidsException("No Consentform where found in given language ID", RitzConstants.ERROR_CODE);
		}
		else
		{
			cr.deleteById(cid);;
			return "Operation Completed";
		}
		
	}

	
	private ConsentForm formMapper(ConsentFormDto fdto)
	{
		ModelMapper mapper=new ModelMapper();
		ConsentForm l=mapper.map(fdto, ConsentForm.class);
		return l;
	}
}
