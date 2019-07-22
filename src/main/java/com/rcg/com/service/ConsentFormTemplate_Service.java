package com.rcg.com.service;

import java.util.List;

import com.rcg.com.dao.ConsentForm;
import com.rcg.com.dao.ConsentFormTemplate;
import com.rcg.com.dto.ConsentFormDto;
import com.rcg.com.dto.ConsentFormTemplateDto;
import com.rcg.com.dto.ConsentformTemplateWrapper;
import com.rcg.com.exceptions.ConstraintsException;
import com.rcg.com.exceptions.RitzkidsException;

public interface ConsentFormTemplate_Service 
{
	//Save Consent form Template
	public String saveConsentForm(ConsentformTemplateWrapper ConsentFormTemplateDtoWrapper,int lid)throws RitzkidsException;
	//Get Consent form Template by ID
	public List<ConsentFormTemplate> getConsentFormById(int cid)throws RitzkidsException;
	//Get All Consent form Template
	public List<ConsentFormTemplate> getAllConsentForm();
	//Update Consent form Template
	public String updateConsentForm(ConsentFormTemplateDto consentformdto,int cid,int lid) throws RitzkidsException,ConstraintsException;
	//Delete Consent form Template
	public String deleteConsentForm(int cid) throws RitzkidsException;
}
